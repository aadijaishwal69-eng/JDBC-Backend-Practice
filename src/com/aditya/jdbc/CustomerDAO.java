package com.aditya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class CustomerDAO {

public void insertCustomer(int id, String name, String country, int score) {

    String sql = "INSERT INTO dbo.customers(id,first_name,country,score) VALUES(?,?,?,?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);) {

        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, country);
        pstmt.setInt(4, score);

        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println(" customer inserted successfully.");
        }


    }catch(SQLException e) {
        System.out.println("customer insertion error");
        e.printStackTrace();
    }

    }


    public void updateCustomerScore(int id, int newScore) {

    String query = "UPDATE dbo.customers SET score = ? WHERE id = ? ";

    try ( Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query);) {

        pst.setInt(1,newScore);
        pst.setInt(2,id);

        int row = pst.executeUpdate();
        if(row > 0 ) {
            System.out.println("customer score updated successfully.");
        } else {
            System.out.println("No Customer found with given id.");
        }

    } catch (SQLException e ) {
        System.out.println("customer update error ! ");
        e.printStackTrace();
    }

    }

    public void deleteCustomer(int id) {

    String sql="DELETE FROM dbo.customers WHERE id = ? ";

    try(  Connection con = DBConnection.getConnection();
          PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1,id);

        int row = pst.executeUpdate();
        if(row > 0 ) {
            System.out.println("customer deleted successfully.");
        } else {
            System.out.println("no Customer found with given id.");
        }

    } catch (SQLException e) {
        System.out.println("customer deletion error!");
        e.printStackTrace();
    }
    }


    public void getALLCustomers() {

    String sql = "SELECT * FROM dbo.customers";

    try(Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);) {

        ResultSet rs =pst.executeQuery();

        System.out.println("id\tfirst_name\tcountry\tscore");
        while(rs.next()) {
            int id =  rs.getInt("id");
            String name = rs.getString("first_name");
            String country = rs.getString("country");
            int score = rs.getInt("score");

            System.out.println(id + "  " + name + "  " + country + "  " + score );
        }
        rs.close();

    } catch (SQLException e) {
        System.out.println("customer retrieval error!");
        e.printStackTrace();
    }
    }


}
