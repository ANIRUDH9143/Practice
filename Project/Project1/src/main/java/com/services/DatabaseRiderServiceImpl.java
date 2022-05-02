package com.services;

import com.models.Rider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("database")
public class DatabaseRiderServiceImpl implements RiderService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Rider createRider(Rider rider) {
        System.out.println(rider);
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.save(rider);
        transaction.commit();
        session.close();
        System.out.println(rider);
        return rider;
    }

    @Override
    public List<Rider> getRiders() {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        List<Rider> riderList = session.createQuery("from Rider where available=false", Rider.class).list();
        transaction.commit();
        session.close();
        return riderList;
    }


    @Override
    public Rider getRiderById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Rider rider=session.get(Rider.class,id);
        transaction.commit();
        session.close();
        return rider;
    }

    @Override
    public Rider updateRider(Rider rider) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(rider);
        session.saveOrUpdate(rider);
        transaction.commit();
        session.close();
        return rider;
    }
}
