package com.genezis.dao;

import com.genezis.model.Timeteable;
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

    }

    @Override
    public List<Timeteable> listTimeteable() {
        return null;
    }

    @Override
    public Timeteable getTimeteable(int id) {
        return null;
    }

    @Override
    public Timeteable editTimeteable(Timeteable timeteable) {
        return null;
    }
}
