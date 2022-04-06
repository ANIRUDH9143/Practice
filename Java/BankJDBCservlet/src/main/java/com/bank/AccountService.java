package com.bank;

import model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    List<Account> getAccounts() throws SQLException;
    void createAccount(Account bank);
    void putAccount(Account bank) throws SQLException, ClassNotFoundException;
    void deleteAccountById(int acc_no);
    List<Account> sortAccounts();
}
