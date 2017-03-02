package com.sethomecompany.dao;

import com.sethomecompany.domain.Timeteable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class TimeteableDAOImpl implements TimeteableDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<Timeteable> getAllTimeteable() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Timeteable");
        List<Timeteable> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Timeteable> getAllTimeteableByProfessorId(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Timeteable a where a.professor.id=:id");
        query.setParameter("id", id);
        List<Timeteable> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Timeteable getTimeteableById(Integer timeteableId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Timeteable a where a.id=:id");
        query.setParameter("id", timeteableId);
        List<Timeteable> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Integer addTimeteable(Timeteable timeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(timeteable);
        session.getTransaction().commit();
        return timeteable.getIdTimeteable();
    }

    @Override
    public void updateTimeteable(Timeteable timeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(timeteable);
        session.getTransaction().commit();
    }

    @Override
    public void deleteTimeteable(Timeteable timeteable) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(timeteable);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public void deleteTimeteableById(Integer id) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Timeteable ifExists(List<Timeteable> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
