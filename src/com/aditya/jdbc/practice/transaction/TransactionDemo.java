package com.aditya.jdbc.practice.transaction;

import java.sql.*;

public class TransactionDemo {

    public static void main (String [] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=myDatabase;encrypt=false;";

        try (Connection conn = DriverManager.getConnection(url,"jdbcuser", "Password@123")) {

            conn.setAutoCommit(false);
            String sql1 = "UPDATE dbo.accounts SET accountBalance = accountBalance - ? WHERE accountId = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql1);
            pstmt.setDouble(1,10000.0);
            pstmt.setInt(2,1);

            int row1 = pstmt.executeUpdate();
            if(row1 > 0 ) {
                System.out.println("Successfully money deducted.");
            } else {
                System.out.println("Failed to deduct money.");
            }

            String sql2 = "UPDATE dbo.accounts SET accountBalance = accountBalance + ? WHERE accountId = ? ";
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setDouble(1,10000.0);
            pstmt2.setInt(2,2);

            int row2 = pstmt2.executeUpdate();
            if(row2 > 0 ) {
                System.out.println("Successfully money credited.");
            } else {
                System.out.println("Failed to credit money .");
            }

            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();

        }}
    }







