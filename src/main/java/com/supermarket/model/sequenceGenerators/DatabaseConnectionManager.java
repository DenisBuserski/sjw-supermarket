package com.supermarket.model.sequenceGenerators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static Connection connection;

    private DatabaseConnectionManager() {}

    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/supermarket?useSSL=false&createDatabaseIfNotExist=true";
            String username = "root";
            String password = "denis";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static synchronized void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
