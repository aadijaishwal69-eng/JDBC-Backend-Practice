package com.aditya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;" +"databaseName=MyDatabase;"+"encrypt=false;";

        try (Connection conn = DriverManager.getConnection(url,"jdbcuser","Password@123")) {

            System.out.println("Database connected successfully.");

            String sql = "UPDATE dbo.customers SET score = ? WHERE id = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,1300);
            pstmt.setInt(2,7);

            int row = pstmt.executeUpdate();
            System.out.println(row + " row update successfully. ");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
