package db.conection;

import utils.DbConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final int INITIAL_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    public static ConnectionPool instance;
    private List<Connection> connectionPool;

    private ConnectionPool() {
        connectionPool = new ArrayList<>();
        initializeConnectionPool();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        Connection connection = null;

        if (!connectionPool.isEmpty()) {
            connection = connectionPool.remove(connectionPool.size() - 1);
            try {
                if (connection.isClosed()) {
                    connection = getConnection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                connection = getConnection();
            }
        } else if (connectionPool.size() < MAX_POOL_SIZE) {
            try {
                connection = createNewConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.add(connection);
        }
    }

    public void closeAllConnections() {
        for (Connection connection : connectionPool) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connectionPool.clear();
    }

    private Connection createNewConnection() throws SQLException {
        String url = DbConfiguration.getUrl();
        String username = DbConfiguration.getUsername();
        String password = DbConfiguration.getPassword();
        return DriverManager.getConnection(url, username, password);
    }

    private void initializeConnectionPool() {
        try {
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                Connection connection = createNewConnection();
                connectionPool.add(connection);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            throw new RuntimeException("Error initializing the connection pool");
        }
    }
}


