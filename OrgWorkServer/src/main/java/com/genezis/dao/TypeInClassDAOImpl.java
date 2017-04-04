package com.genezis.dao;

import com.genezis.model.TypeInClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class TypeInClassDAOImpl implements TypeInClassDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveTypeInClass(TypeInClass typeInClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(typeInClass);
        session.getTransaction().commit();
    }

    @Override
    public List<TypeInClass> listTypeInClass() {
        return null;
    }

    @Override
    public TypeInClass getTypeInClass(int id) {
        return null;
    }

    @Override
    public TypeInClass editTypeInClass(TypeInClass typeInClass) {
        return null;
    }

    @Override
    public void deleteTypeInClass(TypeInClass typeInClass) {
        
    }
}
