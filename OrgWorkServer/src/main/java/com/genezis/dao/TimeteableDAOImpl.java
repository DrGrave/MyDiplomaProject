package com.genezis.dao;

import com.genezis.model.Timeteable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TemporalType;
import java.sql.Time;
import java.util.Date;
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
    public Timeteable getTimeteableByProfessorIdTime(int id, Time time, Date date1) {
        Session session = sessionFactory.getCurrentSession();
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        session.beginTransaction();
        Query query = session.createQuery("from Timeteable t where t.MyUser.id=:id and t.timeToEnd>:myTimeEnd and t.time<:timeStart and year(t.date) = year(:date1) and month(t.date) = month(:date1) and day(t.date) = day(:date1)order by t.id");
        query.setParameter("id",id);
        query.setParameter("myTimeEnd", time);
        query.setParameter("timeStart", time);
        query.setParameter("date1", date1);
        List<Timeteable> list = query.list();
        session.getTransaction().commit();
        return ifExistsTimeteable(list);
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

    private Timeteable ifExistsTimeteable(List<Timeteable> timeteables){
        if(timeteables.size() > 0){
            return timeteables.get(timeteables.size()-1);
        }else {
            return null;
        }
    }
}
