package com.jdbc;
import java.sql.*;
import java.util.*;
public class InsertClass extends DisplayClass{
    public static void insert(Connection connection,Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into book values(?,?)");
            System.out.print("Enter book id: ");
            int id = sc.nextInt();
            System.out.print("Enter book name: ");
            String name = sc.next();
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
        }
        catch(Exception e){
            System.out.println("Some error, try again");
        }
    }
}
