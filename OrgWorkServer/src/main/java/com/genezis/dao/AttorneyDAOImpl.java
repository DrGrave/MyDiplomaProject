package com.genezis.dao;

import com.genezis.model.Attorney;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class AttorneyDAOImpl implements AttorneyDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveAttorney(Attorney attorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(attorney);
        session.getTransaction().commit();
    }

    @Override
    public List<Attorney> listAttorney() {
        return null;
    }

    @Override
    public Attorney getAttorneyById(int id) {
        return null;
    }

    @Override
    public Attorney editAttorney(Attorney attorney) {
        return null;
    }

    @Override
    public void deleteAttorney(Attorney attorney) {

    }
}
