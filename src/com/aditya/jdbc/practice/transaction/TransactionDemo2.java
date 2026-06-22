package com.aditya.jdbc.practice.transaction;

import java.sql.*;
import java.util.*;

public class TransactionDemo2 {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=myDatabase;encrypt=false;";

        try {
            conn = DriverManager.getConnection(url,"jdbcuser","Password@123");

            conn.setAutoCommit(false);
            int id1 =0 , id2 = 0 ;

            System.out.println("Enter the sender Id : ");
            boolean valid = false;
            while(!valid) {
                if(sc.hasNextInt()) {
                    id1 =sc.nextInt();
                    if(id1 > 0 ) {
                        String sql1 = "SELECT accountId FROM accounts WHERE accountId = ? ";

                        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                        pstmt1.setInt(1,id1);

                        ResultSet rs1 = pstmt1.executeQuery();
                        if(rs1.next()) {
                            System.out.println("Successfully verified sender ID .");
                            valid = true;
                            rs1.close();
                        } else {
                            System.out.println("Invalid sender ID :");
                            System.out.println("Please enter a valid sender ID : pra");
                        }
                        pstmt1.close();
                    } else{
                        System.out.println("INVALID ID ! \n Please enter a valid ID : ");

                    }
                } else {
                    System.out.println("Please enter a valid ID : ");
                    sc.next();
                }
            }

            System.out.println("Enter the receiver Id : ");
            boolean valid2 = false;
            while(!valid2) {
                if(sc.hasNextInt()) {
                    id2 = sc.nextInt();
                    if(id2 > 0 ) {
                        String sql2 = "SELECT accountId FROM accounts WHERE accountId = ? ";

                        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                        pstmt2.setInt(1,id2);

                        ResultSet rs2 = pstmt2.executeQuery();
                        if(rs2.next()) {
                            System.out.println("Successfully verified receiver ID .");
                            if(id1 == id2) {
                                System.out.println("INVALID ! \n Both ID's are same \n Please enter different ID's :");
                                return;
                            }
                            valid2 = true;
                            rs2.close();
                        } else {
                            System.out.println("Invalid receiver ID :");
                            System.out.println("Please enter a valid ID :");
                        }
                        pstmt2.close();
                    } else {
                        System.out.println("INVALID ID ! \n Please enter a valid ID : ");
                    }
                } else {
                    System.out.println("Please enter a valid ID : ");
                    sc.next();
                }
            }

            System.out.println("Enter the amount : ");
            double amount = sc.nextDouble();
            if(amount <= 0 ) {
                System.out.println("Amount must be greater than 0.");
                return;
            }


            String sql3 = "SELECT accountBalance FROM accounts WHERE accountId = ? ";

            PreparedStatement pstmt3 = conn.prepareStatement(sql3);
            pstmt3.setInt(1,id1);

            ResultSet rs3 = pstmt3.executeQuery();

            if(rs3.next()) {
                double balance = rs3.getDouble("accountBalance");

                if(balance >= amount) {
                    System.out.println("Sender have sufficient balance.");
                } else {
                    System.out.println("sender doesnot have sufficient balance.");
                    return ;
                }
            }
            rs3.close();



            String sql4 = "UPDATE accounts SET accountBalance = accountBalance - ? WHERE accountId = ? ";
            PreparedStatement pstmt4 = conn.prepareStatement(sql4);

            pstmt4.setDouble(1,amount);
            pstmt4.setInt(2,id1);

            int row1 = pstmt4.executeUpdate();

            String sql5 = "UPDATE accounts SET accountBalance = accountBalance + ? WHERE accountId = ? ";
            PreparedStatement pstmt5 = conn.prepareStatement(sql5);

            pstmt5.setDouble(1,amount);
            pstmt5.setInt(2,id2);

            int row2 = pstmt5.executeUpdate();

            if(row1 == 1 && row2 ==1) {
                conn.commit();
                System.out.println("Transaction successful.");
            } else {
                System.out.println("Transaction failed.");
                conn.rollback();
            }

            pstmt3.close();
            pstmt4.close();
            pstmt5.close();


        } catch (SQLException e) {
            e.printStackTrace();
             try {
                 if(conn != null) {
                     conn.rollback();
                 }
             } catch (SQLException e1) {
                 System.out.println("Rollback failed." + e1.getMessage());
             }
        } finally {
            sc.close();
           try {
               if(conn != null) {
                   conn.setAutoCommit(true);
                   conn.close();
               }
           } catch (SQLException e) {
               System.out.println("Close connection failed. " +e.getMessage());
           }

        }
    }
}
