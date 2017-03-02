package com.sethomecompany.dao;

import com.sethomecompany.domain.TypeOfAttorney;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class TypeOfAttorneyDAOIpl implements TypeOfAttorneyDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<TypeOfAttorney> getAllTypeOfAttorney() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeOfAttorney");
        List<TypeOfAttorney> list = query.list();
        session.delete(ifExists(list));
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Integer addTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(typeOfAttorney);
        session.getTransaction().commit();
        return typeOfAttorney.getIdTypeOfAttorney();
    }

    @Override
    public void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(typeOfAttorney);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public TypeOfAttorney getTypeOfAttorney(Integer idTypeOfAttorney) {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private TypeOfAttorney ifExists(List<TypeOfAttorney> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
