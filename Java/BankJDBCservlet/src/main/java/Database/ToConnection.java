package Database;
import com.bank.Account;
import com.bank.BankServiceImpl;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.List;

public class ToConnection {
    private static Logger logger= LoggerFactory.getLogger(ToConnection.class);
    public static Statement statement=null;
    public static Connection connection=null;
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankServletJDBC", "root", "mysql");
            logger.info("established"+connection.toString());
            statement=connection.createStatement();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public static ResultSet getList() throws SQLException {
        connection=connect();
        ResultSet resultSet=connection.createStatement().executeQuery("select * from account");
        return resultSet;
    }

    public static void updateAccount(Account account){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET customer_id =?, account_type=?,balance=? WHERE account_number = " + account.getAccount_number());
            preparedStatement.setInt(1, account.getCustomer_id());
            preparedStatement.setString(2, account.getType());
            preparedStatement.setInt(3, account.getBalance());

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void createAcc(Account account){
        Logger logger= LoggerFactory.getLogger(BankServiceImpl.class);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = connect();
            logger.info("after connection");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into account values(?,?,?,?)");

            preparedStatement.setInt(1, account.getAccount_number());
            preparedStatement.setInt(2, account.getCustomer_id());
            preparedStatement.setString(3, account.getType());
            preparedStatement.setInt(4, account.getBalance());

            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteAcc(int account_no){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from account where account_number=" + account_no);
            preparedStatement.execute();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
//    public static void sortacc(HttpServletResponse resp, Gson GSON) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = connect();
//            ResultSet resultSet=connection.createStatement().executeQuery("select * from account order by customer_id");
//            resp.getOutputStream().println(GSON.toJson(resultSet));
//
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }

}
