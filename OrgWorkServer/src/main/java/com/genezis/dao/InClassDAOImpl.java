package com.genezis.dao;

import com.genezis.model.InClass;
import org.hibernate.Query;
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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from InClass");
        List<InClass> inClasses = query.list();
        session.getTransaction().commit();
        return inClasses;
    }

    @Override
    public InClass getInClass(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from InClass ic where ic.id=:id");
        query.setParameter("id",id);
        List<InClass> inClasses = query.list();
        session.getTransaction().commit();
        return ifExists(inClasses);
    }

    @Override
    public InClass editInClass(InClass inClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(inClass);
        session.getTransaction().commit();
        return inClass;
    }

    @Override
    public void deleteInClass(InClass inClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(inClass);
        session.getTransaction().commit();
    }

    @Override
    public InClass ifExistsInClass(InClass inClass) {
        return null;
    }

    private InClass ifExists(List<InClass> inClasses){
        if(inClasses.size() > 0){
            return inClasses.get(0);
        }else {
            return null;
        }
    }
}
