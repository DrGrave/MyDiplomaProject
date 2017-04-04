package com.genezis.dao;

import com.genezis.model.TypeOfWork;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class TypeOfWorkDAOImpl implements TypeOfWorkDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveTypeOfWork(TypeOfWork typeOfWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(typeOfWork);
        session.getTransaction().commit();
    }

    @Override
    public List<TypeOfWork> listTypeOfWork() {
        return null;
    }

    @Override
    public TypeOfWork getTypeOfWork(int id) {
        return null;
    }

    @Override
    public TypeOfWork editTypeOfWork(TypeOfWork typeOfWork) {
        return null;
    }

    @Override
    public void deleteTypeOfWork(TypeOfWork typeOfWork) {

    }
}
