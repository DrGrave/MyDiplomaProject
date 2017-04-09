package com.genezis.dao;

import com.genezis.model.M2MGroupTimeteable;
import com.genezis.model.Queue;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
public class M2MGroupTimeteableDAOImpl implements M2MGroupTimeteableDAO{
    private SessionFactory sessionFactory;

    @Override
    public void saveM2MGroupTimeteable(M2MGroupTimeteable m2mGroupTimeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(m2mGroupTimeteable);
        session.getTransaction().commit();
    }

    @Override
    public List<M2MGroupTimeteable> listM2MGroupTimeteable() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from M2MGroupTimeteable");
        List<M2MGroupTimeteable> m2MGroupTimeteables = query.list();
        session.getTransaction().commit();
        return m2MGroupTimeteables;
    }

    @Override
    public M2MGroupTimeteable getM2MGroupTimeteable(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from  M2MGroupTimeteable gt where gt.id=:id");
        query.setParameter("id",id);
        List<M2MGroupTimeteable> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public M2MGroupTimeteable editM2MGroupTimeteable(M2MGroupTimeteable m2mGroupTimeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(m2mGroupTimeteable);
        session.getTransaction().commit();
        return m2mGroupTimeteable;
    }

    @Override
    public void deleteM2MGroupTimeteable(M2MGroupTimeteable m2mGroupTimeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(m2mGroupTimeteable);
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private M2MGroupTimeteable ifExists(List<M2MGroupTimeteable> inClasses){
        if(inClasses.size() > 0){
            return inClasses.get(0);
        }else {
            return null;
        }
    }
}
