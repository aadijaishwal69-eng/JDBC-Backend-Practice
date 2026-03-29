package com.aditya.jdbc;

import java.sql.*;


public class  Test {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;"+"databaseName=MYdatabase;"+"encrypt=false;";

        try(Connection conn = DriverManager.getConnection(url,"jdbcuser","Password@123")) {
            System.out.println("Database connected successfully.");

        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
