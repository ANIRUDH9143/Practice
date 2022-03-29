package com.jdbc;
import java.sql.*;
import java.util.*;
public class Library extends InsertClass{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql");
            Statement statement = connection.createStatement();
            while(true) {
                    System.out.print("1: Insert\n2: Display\n3: Search\n4: Delete\n5: Exit\nEnter option number:");
                    int op = sc.nextInt();
                    switch (op) {
                        case 1:
                            insert(connection,sc);
                            break;
                        case 2:
                            display(statement);
                            break;
                        case 3:
                            search(statement,sc);
                            break;
                        case 4:
                            delete(connection,statement,sc);
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Enter given options only bro. Kindha chudu\n");
                    }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Some error, try again");
        }
    }
}
