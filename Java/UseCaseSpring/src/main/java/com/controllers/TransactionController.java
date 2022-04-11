package com.controllers;

import com.models.Transaction;
import com.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    @Qualifier("database")
    private TransactionsService transactionsService;

    public TransactionController(){
    }
    @RequestMapping("/GET")
    public List<Transaction> getTransactions(){
        return transactionsService.getTransactions();
    }
    @RequestMapping("/GET/{id}")
    public Transaction getBookById(@PathVariable("id") int bookId){
        return transactionsService.getTransactionById(bookId);
    }
    @RequestMapping("/POST")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        transactionsService.createTransaction(transaction);
        return transaction;
    }
    @RequestMapping("/PUT")
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        transactionsService.updateTransaction(transaction);
        return transaction;
    }
    @RequestMapping("/DELETE/{id}")
    public Transaction deleteTransactionById(@PathVariable("id") int id){
        Transaction transaction=transactionsService.getTransactionById(id);
        transactionsService.deleteTransactionById(id);
        return(transaction);
    }

}
