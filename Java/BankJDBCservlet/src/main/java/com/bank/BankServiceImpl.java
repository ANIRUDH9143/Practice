package com.bank;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Database.ToConnection.*;


public class BankServiceImpl implements BankService{
    public Connection connection=null;
    private final List<Account> accountList=new ArrayList<>();
    @Override
    public List<Account> getAccounts() throws SQLException {

        try {
            connection = connect();
            ResultSet resultSet = getList();
            while (resultSet.next()) {

                Account account = new Account();
                account.setAccount_number(resultSet.getInt(1));
                account.setCustomer_id(resultSet.getInt(2));
                account.setType(resultSet.getString(3));
                account.setBalance(resultSet.getInt(4));
                accountList.add(account);

            }
            connection.close();
            return accountList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void createAccount(Account account) {
        createAcc(account);
    }

    @Override
    public Account putAccount(Account account) throws SQLException, ClassNotFoundException {
        updateAccount(account);
        return null;
    }

    @Override
    public Account deleteAccountById(int acc_no) {

        deleteAcc(acc_no);
        return null;
    }

//    @Override
//    public void sortAccounts(HttpServletResponse resp, Gson GSON) {
//
//        sortacc(resp,GSON);
//    }
}
