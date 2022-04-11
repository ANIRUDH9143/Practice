package com.services;

import com.models.Transaction;

import java.util.List;

public interface TransactionsService {
    List<Transaction> getTransactions();
    Transaction getTransactionById(int id);
    Transaction createTransaction(Transaction book);
    Transaction updateTransaction(Transaction book);
    Transaction deleteTransactionById(int id);
}
