package com.aditya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionTest {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;" + "databaseName=MyDatabase;" + "encrypt=false;";

        try (Connection conn = DriverManager.getConnection(url, "jdbcuser", "Password@123")) {
            System.out.println("jdbc connected successfully.");
        } catch ( SQLException e)
    {
        e.printStackTrace();

    }

    }
}