package com.services;

import com.models.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("database")
public class DatabaseTransactionServiceImpl implements TransactionsService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Transaction> getTransactions() {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        List<Transaction> transactionList = session.createQuery("from Transaction", Transaction.class).list();
        transaction.commit();
        session.close();

        return transactionList;
    }

    @Override
    public Transaction getTransactionById(int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Transaction transaction1=session.get(Transaction.class,id);
        transaction.commit();
        session.close();

        return transaction1;
    }

    @Override
    public Transaction createTransaction(Transaction transaction1) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.save(transaction1);
        transaction.commit();
        session.close();

        return transaction1;
    }

    @Override
    public Transaction updateTransaction(Transaction transaction1) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.update(transaction1);
        transaction.commit();
        session.close();

        return transaction1;
    }

    @Override
    public Transaction deleteTransactionById(int id) {
        Transaction transaction1;
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Transaction transaction2=session.get(Transaction.class,id);
        transaction1=transaction2;
        session.delete(transaction2);
        transaction.commit();
        session.close();

        return transaction1;
    }
}
