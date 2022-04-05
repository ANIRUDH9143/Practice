package com.bank;
import model.Account;

import java.sql.SQLException;
import java.util.List;

import static Database.ToConnection.*;


public class AccountServiceImpl implements AccountService {

    @Override
    public List<Account> getAccounts() throws SQLException {
        return(getList());
    }
    @Override
    public void createAccount(Account account) {
        createAcc(account);
    }

    @Override
    public void putAccount(Account account){
        updateAccount(account);
    }

    @Override
    public void deleteAccountById(int acc_no) {
        deleteAcc(acc_no);
    }

    @Override
    public List<Account> sortAccounts() {
        return sortAcc();
    }
}
