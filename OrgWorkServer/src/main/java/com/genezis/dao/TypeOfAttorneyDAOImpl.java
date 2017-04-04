package com.genezis.dao;

import com.genezis.model.TypeOfAttorney;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class TypeOfAttorneyDAOImpl implements TypeOfAttorneyDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(typeOfAttorney);
        session.getTransaction().commit();
    }

    @Override
    public List<TypeOfAttorney> listTypeOfAttorney() {
        return null;
    }

    @Override
    public TypeOfAttorney getTypeOfAttorney(int id) {
        return null;
    }

    @Override
    public TypeOfAttorney editTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        return null;
    }

    @Override
    public void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        
    }
}
