package com.jdbc;
import java.sql.*;
import java.util.*;
public class DeleteClass {
    public static void delete(Connection connection,Statement statement,Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Enter book id to delete:");
            int del = sc.nextInt();
            ResultSet resultSet=statement.executeQuery("select name from book where id="+del);
            if(resultSet.next()){
            PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id=" + del);
            preparedStatement.execute();
            System.out.println("Deletion Successful");
            }
            else
                System.out.println("Row not found to delete, hence for you it's deleted.");
        }
        catch(Exception e){
            System.out.println("Some error, try again");
        }
    }
}
