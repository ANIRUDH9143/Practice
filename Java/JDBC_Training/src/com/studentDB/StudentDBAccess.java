package com.studentDB;
import java.sql.*;
import java.util.*;
public class StudentDBAccess {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection connection=null;
        Statement statement=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","mysql");
            statement=connection.createStatement();

            PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?)");

            System.out.print("Enter id: ");
            int id=sc.nextInt();
            System.out.print("Enter name: ");
            String name=sc.next();
            System.out.print("Enter address: ");
            String address=sc.next();

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,address);
            preparedStatement.executeUpdate();
            ResultSet resultSet=statement.executeQuery("select * from student");

            while (resultSet.next()){
                System.out.println("Student id: "+resultSet.getInt(1));//instraed of 1 column name
                System.out.println("Student name: "+resultSet.getString(2));
                System.out.println("Student address: "+resultSet.getString(3));
                System.out.println("=============================");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
