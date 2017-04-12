package com.genezis.dao;

import com.genezis.model.TypeOfAcceptWork;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Vadim on 12.04.2017.
 */
public class TypeOfAccaptWorkDAOImpl implements TypeOfAccaptWorkDAO {
    private SessionFactory sessionFactory;

    @Override
    public void saveTypeOfAccaptWork(TypeOfAcceptWork typeOfAcceptWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(typeOfAcceptWork);
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
