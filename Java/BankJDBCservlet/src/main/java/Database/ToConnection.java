package Database;
import com.bank.TransactionService;
import model.Account;
import model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ToConnection<sortedList> {
    public static Statement statement = null;
    public static Connection connection = null;
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankServletJDBC", "root", "mysql");
            statement = connection.createStatement();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Account> getList() {
        List<Account> accountList = new ArrayList<>();
        try {
            connection = connect();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccount_number(resultSet.getInt(1));
                account.setCustomer_id(resultSet.getInt(2));
                account.setType(resultSet.getString(3));
                account.setBalance(resultSet.getInt(4));
                accountList.add(account);
            }
            return accountList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////
    public static List<Transaction> getTransactions() {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            connection = connect();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from transaction");
            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt(1));
                transaction.setFrom_acc_no(resultSet.getInt(2));
                transaction.setTo_acc_no(resultSet.getInt(3));
                transaction.setAmount(resultSet.getInt(4));
                transactionList.add(transaction);
            }
            return transactionList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void updateAccount(Account account) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET customer_id =?, type=?,balance=? WHERE account_number = " + account.getAccount_number());
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

    public static void createAcc(Account account) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into account values(?,?,?,?)");
            preparedStatement.setInt(1, account.getAccount_number());
            preparedStatement.setInt(2, account.getCustomer_id());
            preparedStatement.setString(3, account.getType());
            preparedStatement.setInt(4, account.getBalance());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAcc(int account_no) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from account where account_number=" + account_no);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Account> sortAcc() {
        List<Account> sortedList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = connect();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from account order by customer_id");
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccount_number(resultSet.getInt(1));
                account.setCustomer_id(resultSet.getInt(2));
                account.setType(resultSet.getString(3));
                account.setBalance(resultSet.getInt(4));
                sortedList.add(account);
            }
            return sortedList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}



