package com.bank;

import model.Account;
import model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions() throws SQLException;
    void createTransaction(Transaction transaction);
    void putTransaction(Transaction transaction) throws SQLException, ClassNotFoundException;
    void deleteTransactionById(int id);
}




