package com.aditya.jdbc;

import java.sql.*;
import java.util.Scanner;

public class CRUD {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;"+"databaseName=MyDatabase;"+"encrypt=false;";
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(url,"jdbcuser","Password@123")) {

            System.out.println("Database connected successfully.");

            int choice;
            do {
                System.out.println("Enter your choice : \n 1.insert \n 2.update \n 3.delete \n 4.select \n 5.exit \n");
                 choice = sc.nextInt();

                 switch (choice) {
                     case 1:
                         System.out.println("Enter id: ");
                         int id = sc.nextInt();
                         sc.nextLine();
                         System.out.println("Enter name : ");
                         String name = sc.nextLine();
                         System.out.println("Enter country : ");
                         String country = sc.nextLine();
                         System.out.println("Enter score: ");
                         int score = sc.nextInt();

                         String sql = "INSERT INTO dbo.customers(id,first_name,country,score) VALUES (?,?,?,?)";
                         PreparedStatement pstmt = conn.prepareStatement(sql);

                         pstmt.setInt(1, id);
                         pstmt.setString(2, name);
                         pstmt.setString(3, country);
                         pstmt.setInt(4, score);

                         int row = pstmt.executeUpdate();
                         System.out.println(row + " row(s) inserted successfully.");
                         pstmt.close();
                         break;

                     case 2:
                         System.out.println("Enter id: ");
                         int customer_id = sc.nextInt();
                         System.out.println("Enter new score: ");
                         int new_score = sc.nextInt();

                         String s = "UPDATE dbo.customers SET score = ? WHERE id = ? ";
                         PreparedStatement stmt = conn.prepareStatement(s);
                         stmt.setInt(1, new_score);
                         stmt.setInt(2, customer_id);

                         int rows = stmt.executeUpdate();
                         System.out.println(rows + " row(s) updated successfully.");
                         stmt.close();
                         break;

                     case 3:
                         System.out.println("Enter id of the row u want to delete : ");
                         int _id = sc.nextInt();
                         String s1 = "DELETE FROM  dbo.customers WHERE id = ? ";
                         PreparedStatement stmt1 = conn.prepareStatement(s1);
                         stmt1.setInt(1, _id);
                         int _row = stmt1.executeUpdate();
                         System.out.println(_row + " row(s) deleted successfully.");
                         stmt1.close();
                         break;

                     case 4:
                         String s2 = "SELECT * FROM dbo.customers";
                         PreparedStatement pstmt1 = conn.prepareStatement(s2);

                         ResultSet rs = pstmt1.executeQuery();
                         while (rs.next()) {
                             int custId = rs.getInt("id");
                             String custName = rs.getString("first_name");
                             String custCountry = rs.getString("country");
                             int custScore = rs.getInt("score");


                             System.out.println(custId + " " + custName + " " + custCountry + " " + custScore);

                         }
                         rs.close();
                         pstmt1.close();
                         break;

                     case 5:
                         System.out.println("Existing ...");
                         break;
                     default:
                         System.out.println("INVALID CHOICE !");

                 } }
            while (choice != 5);

        } catch (SQLException e ) {
            e.printStackTrace();
        }

        sc.close();

}}
