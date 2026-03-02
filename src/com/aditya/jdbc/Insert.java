package com.aditya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;"+"databaseName=MyDatabase;"+"encrypt=false;";

        try (Connection conn = DriverManager.getConnection(url,"jdbcuser","Password@123")) {

            System.out.println("Database connected successfully.");

            String sql = "INSERT INTO dbo.customers (id, first_name , country, score) VALUES (? ,? ,? ,? );";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 7);
            pstmt.setString(2, "Rohit");
            pstmt.setString(3 , "India");
            pstmt.setInt(4 , 900);

            int row = pstmt.executeUpdate();
            System.out.println(row + " row inserted successfully.");

        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }
}