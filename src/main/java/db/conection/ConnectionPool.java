package db.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final String URL = "jdbc:mysql://localhost:3306/dealership";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ge13066";
    private static final int INITIAL_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private List<Connection> connectionPool;

    public ConnectionPool() {
        connectionPool = new ArrayList<>();

        try {
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                connectionPool.add(connection);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
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
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public synchronized void releaseConnection(Connection connection){
        if(connection!=null){
            connectionPool.add(connection);
        }
    }

    public void closeAllConnections(){
        for(Connection connection : connectionPool){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connectionPool.clear();
    }


}


