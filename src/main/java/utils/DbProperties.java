package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbProperties {
    private static final String PROPERTIES_FILE_PATH = "src/main/resources/db.properties";
    private static DbProperties instance;
    private String url;
    private String username;
    private String password;

    private DbProperties() {
        loadProperties();
    }

    public static synchronized DbProperties getInstance() {
        if (instance == null) {
            instance = new DbProperties();
        }
        return instance;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private void loadProperties() {
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
}
