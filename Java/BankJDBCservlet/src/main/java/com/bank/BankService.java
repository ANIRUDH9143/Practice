package com.bank;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface BankService {
    List<Account> getAccounts() throws SQLException;
    void createAccount(Account bank);
    Account putAccount(Account bank) throws SQLException, ClassNotFoundException;
    Account deleteAccountById(int acc_no);
//    void sortAccounts(HttpServletResponse resp, Gson GSON);
}
