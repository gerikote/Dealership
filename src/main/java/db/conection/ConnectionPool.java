package db.conection;

import utils.DBConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
    private static ConnectionPool instance = null;
    private static final int INITIAL_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static Vector<Connection> freeConnections = new Vector<>();
    private static Vector<Connection> usedConnections = new Vector<>();

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
            create();
        }
        return instance;
    }

    public static void create() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnections.add(createNewConnectionForPool());
        }
    }

    private static Connection createNewConnectionForPool() {
        String url = DBConfiguration.getUrl();
        String username = DBConfiguration.getUsername();
        String password = DBConfiguration.getPassword();

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public synchronized Connection getConnection() {
        if (freeConnections.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                Connection connection = createNewConnectionForPool();
                usedConnections.add(connection);
                return connection;
            } else {
                throw new RuntimeException("Connection pool limit reached, unable to provide a connection.");
            }
        } else {
            Connection connection = freeConnections.remove(freeConnections.size() - 1);
            usedConnections.add(connection);
            return connection;
        }
    }

    public synchronized void releaseConnection(Connection connection) {
        usedConnections.remove(connection);
        freeConnections.add(connection);
    }
}

