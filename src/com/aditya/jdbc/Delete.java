package com.aditya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;"+"databaseName=MyDatabase;"+"encrypt=false;";

        try ( Connection conn = DriverManager.getConnection(url,"jdbcuser","Password@123")) {

            System.out.println("Database connected successfully.");

            String sql = "DELETE FROM dbo.customers WHERE id = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,7);

            int row = pstmt.executeUpdate();
            System.out.println(row + " row(s) deleted successfully .");

    } catch(SQLException e) {
            e.printStackTrace();
        }

        }
}
