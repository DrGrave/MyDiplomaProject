package com.genezis.dao;

import com.genezis.model.Timeteable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class TimeteableDAOImpl implements TimeteableDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveTimeteable(Timeteable timeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(timeteable);
        session.getTransaction().commit();
    }

    @Override
    public List<Timeteable> listTimeteable() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from  Timeteable");
        List<Timeteable> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Timeteable getTimeteable(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Timeteable t where t.id=:id");
        query.setParameter("id",id);
        List<Timeteable> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Timeteable editTimeteable(Timeteable timeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(timeteable);
        session.getTransaction().commit();
        return timeteable;
    }

    @Override
    public void deleteTimeteable(Timeteable timeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(timeteable);
        session.getTransaction().commit();
    }

    @Override
    public Timeteable ifExistsTimeteable(Timeteable timeteable) {
        return null;
    }

    private Timeteable ifExists(List<Timeteable> timeteables){
        if(timeteables.size() > 0){
            return timeteables.get(0);
        }else {
            return null;
        }
    }
}
