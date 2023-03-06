package com.example.stafflist.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class StaffConnection {
    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;

    {
        jdbcURL = "jdbc:mysql://localhost:3306/staff_management?useSSL=false";
        jdbcUsername = "root";
        jdbcPassword = "Huynhitu12";
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
