package com.genezis.dao;

import com.genezis.model.TypeOfAttorney;
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
}
