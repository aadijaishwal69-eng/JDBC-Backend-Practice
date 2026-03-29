package com.aditya.jdbc;

import java.util.*;

public class MenuService {

    CustomerDAO dao = new CustomerDAO();

    public void start() {

        Scanner sc = new Scanner(System.in);


        int choice;

        do {
            System.out.println("\nOur Menuservice: \n");
            System.out.println("Enter your choice: \n 1.insert a customer " +
                    "\n 2.update a customer score" +
                    " \n 3.delete a customer" +
                    " \n 4.select all customers" +
                    " \n 5 exit ");
            choice = sc.nextInt();

            switch(choice) {
                case 1 :
                    System.out.println("\n input the given details to insert a customer : \n");
                    System.out.println("Enter the id of the customer: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the first  name of the customer: " );
                    String name = sc.nextLine();
                    System.out.println("Enter the country of the customer: ");
                    String country = sc.nextLine();
                    System.out.println("Enter the score of the customer: ");
                    int score = sc.nextInt();

                    dao.insertCustomer(id,name,country,score);
                    break;

                case 2:
                    System.out.println("\n Enter the given details to update a customer score: \n");
                    System.out.println("Enter the id of the customer to be updated: ");
                    int cid = sc.nextInt();
                    System.out.println("Enter the new score of the customer: ");
                    int newScore = sc.nextInt();

                    dao.updateCustomerScore(cid,newScore);
                    break;

                case 3:
                    System.out.println("Enter the id of the customer to be deleted: ");
                    int custId = sc.nextInt();

                    dao.deleteCustomer(custId);
                    break;

                case 4:
                    System.out.println("\n Displaying all the customers details: \n");
                    dao.getALLCustomers();
                    break;

                case 5 :
                    System.out.println("Exiting ...");
                    break;

                default:
                    System.out.println("INVALID INPUT: \n please enter your choice again:");

            }

        } while (choice != 5);
        sc.close();
    }

}
