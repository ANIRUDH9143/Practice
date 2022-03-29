package com.jdbc;
import java.sql.*;
public class DisplayClass extends SearchClass{
    public static void display(Statement statement) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery("select * from book");

            while (resultSet.next()) {
                System.out.print("Book id: " + resultSet.getInt(1)+"  ");//instead of 1 column name
                System.out.println("Book name: " + resultSet.getString(2));
                System.out.println("=============================");
            }
        }
        catch(Exception e){
            System.out.println("Some error, try again");
        }
    }
}
