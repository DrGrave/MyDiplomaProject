package com.genezis.dao;

import com.genezis.model.TypeInClass;
import org.hibernate.Query;
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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeInClass");
        List<TypeInClass> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public TypeInClass getTypeInClass(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeInClass tin where tin.id=:id");
        query.setParameter("id",id);
        List<TypeInClass> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public TypeInClass editTypeInClass(TypeInClass typeInClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(typeInClass);
        session.getTransaction().commit();
        return typeInClass;
    }

    @Override
    public void deleteTypeInClass(TypeInClass typeInClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(typeInClass);
        session.getTransaction().commit();
    }

    @Override
    public TypeInClass ifExistsTypeInClass(TypeInClass typeInClass) {
        return null;
    }

    private TypeInClass ifExists(List<TypeInClass> typeInClasses){
        if(typeInClasses.size() > 0){
            return typeInClasses.get(0);
        }else {
            return null;
        }
    }
}
