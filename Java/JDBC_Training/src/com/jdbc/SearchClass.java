package com.jdbc;
import java.sql.*;
import java.util.*;
public class SearchClass extends DeleteClass{
    public static void search(Statement statement,Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Enter book id to search:");
            int search = sc.nextInt();
            System.out.println();
            ResultSet resultSet2 = statement.executeQuery("select name from book where id=" + search);
            if(resultSet2.next()) {
                System.out.println("Found the book");
                System.out.println("Book name: "+resultSet2.getString(1));
                System.out.println();
            }
            else
                System.out.println("Book not found");
        }
        catch(Exception e){
            System.out.println("Some error, try again");
        }
    }
}
