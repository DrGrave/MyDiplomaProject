package com.genezis.dao;

import com.genezis.model.InClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class InClassDAOImpl implements InClassDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveInClass(InClass inClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(inClass);
        session.getTransaction().commit();
    }

    @Override
    public List<InClass> listInClass() {
        return null;
    }

    @Override
    public InClass getInClass(int id) {
        return null;
    }

    @Override
    public InClass editInClass(InClass inClass) {
        return null;
    }

    @Override
    public void deleteInClass(InClass inClass) {

    }
}
