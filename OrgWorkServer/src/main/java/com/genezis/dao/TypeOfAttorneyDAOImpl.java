package com.genezis.dao;

import com.genezis.model.TypeOfAttorney;
import org.hibernate.Query;
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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeOfAttorney");
        List<TypeOfAttorney> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public TypeOfAttorney getTypeOfAttorney(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeOfAttorney tof where tof.id=:id");
        query.setParameter("id",id);
        List<TypeOfAttorney> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public TypeOfAttorney editTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(typeOfAttorney);
        session.getTransaction().commit();
        return typeOfAttorney;
    }

    @Override
    public void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(typeOfAttorney);
        session.getTransaction().commit();
    }

    @Override
    public TypeOfAttorney ifExistsTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        return null;
    }

    private TypeOfAttorney ifExists(List<TypeOfAttorney> typeOfAttorneys){
        if(typeOfAttorneys.size() > 0){
            return typeOfAttorneys.get(0);
        }else {
            return null;
        }
    }
}
