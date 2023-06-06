package db.conection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static final String PROPERTIES_FILE_PATH = "src/main/resources/db.properties";
    private static final int INITIAL_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    public static ConnectionPool instance;
    private List<Connection> connectionPool;
    private String url;
    private String username;
    private String password;

    private ConnectionPool() {
        connectionPool = new ArrayList<>();
        loadDbProperties();
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
                connection = DriverManager.getConnection(url, username, password);
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

    private void loadDbProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading db.properties file");
        }

        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

    }

    private void initializeConnectionPool() {
        try {
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                connectionPool.add(connection);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            throw new RuntimeException("Error initializing the connection pool");
        }
    }
}


