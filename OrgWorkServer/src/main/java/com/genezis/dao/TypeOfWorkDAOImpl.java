package com.genezis.dao;

import com.genezis.model.TypeOfWork;
import org.hibernate.Query;
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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeOfWork");
        List<TypeOfWork> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public TypeOfWork getTypeOfWork(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeOfWork tof where tof.id=:id");
        query.setParameter("id", id);
        List<TypeOfWork> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public TypeOfWork editTypeOfWork(TypeOfWork typeOfWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(typeOfWork);
        session.getTransaction().commit();
        return typeOfWork;
    }

    @Override
    public void deleteTypeOfWork(TypeOfWork typeOfWork) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction();
        session.delete(typeOfWork);
        session.getTransaction().commit();
    }

    @Override
    public TypeOfWork ifExistsTypeOfWork(TypeOfWork typeOfWork) {
        return null;
    }

    private TypeOfWork ifExists(List<TypeOfWork> typeOfWorks){
        if(typeOfWorks.size() > 0){
            return typeOfWorks.get(0);
        }else {
            return null;
        }
    }
}
