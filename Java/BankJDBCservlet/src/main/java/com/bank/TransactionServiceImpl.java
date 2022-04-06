package com.bank;

import model.Transaction;

import java.sql.SQLException;
import java.util.List;

import static Database.ToConnection.getList;

public class TransactionServiceImpl implements TransactionService{
    @Override
    public List<Transaction> getTransactions() throws SQLException {
        return(getTransactions());

    }

    @Override
    public void createTransaction(Transaction transaction) {

    }

    @Override
    public void putTransaction(Transaction transaction) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void deleteTransactionById(int id) {

    }
}
