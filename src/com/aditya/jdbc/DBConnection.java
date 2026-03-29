package com.aditya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private DBConnection() {
    // prevent object creation
    }


    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=MyDatabase;encrypt=false;";
    private static final String USERNAME = "jdbcuser";
    private static final String PASSWORD = "Password@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

}
