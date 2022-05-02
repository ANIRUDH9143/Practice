package com.services;

import com.models.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("database2")
public class DatabasePassengerServiceImpl implements PassengerService {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Passenger createPassenger(Passenger passenger) {
        System.out.println(passenger);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passenger);
        transaction.commit();
        session.close();
        return passenger;
    }

    @Override
    public List<Passenger> getPassengers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Passenger> passengerList = session.createQuery("from Passenger", Passenger.class).list();
        transaction.commit();
        session.close();
        return passengerList;
    }


    @Override
    public Passenger getPassengerById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Passenger passenger=session.get(Passenger.class,id);
        transaction.commit();
        session.close();

        return passenger;
    }
}
