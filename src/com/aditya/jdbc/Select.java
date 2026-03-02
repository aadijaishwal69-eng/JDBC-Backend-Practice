package com.aditya.jdbc;

import java.sql.*;

public class Select {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;" + "databaseName=MyDatabase;" + "encrypt=false;";

        try (Connection conn = DriverManager.getConnection(url, "jdbcuser", "Password@123")) {

            System.out.println("DATABASE CONNECTED SUCCESSFULLY .");

            String sql = "SELECT * FROM dbo.customers ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

                        ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String country = rs.getString("country");
                int score = rs.getInt("score");

                System.out.println(id + " " + first_name + " " + country + " " + score );

            }

            System.out.println("DATA RETRIEVED SUCCESSFULLY. ");
            rs.close();
            pstmt.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
