package com.spendwise.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/spendwise";
    private static final String USER = "spendwise-app";
    private static final String PASSWORD = "senha1234@A";

    public static Connection getConnection() throws SQLException {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            throw new SQLException(e);

        }
    }
}


