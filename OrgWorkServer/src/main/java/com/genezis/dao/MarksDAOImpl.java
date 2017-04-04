package com.genezis.dao;

import com.genezis.model.Marks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class MarksDAOImpl implements MarksDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveMarks(Marks marks) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(marks);
        session.getTransaction().commit();
    }

    @Override
    public List<Marks> listMarks() {
        return null;
    }

    @Override
    public Marks getMarks(int id) {
        return null;
    }

    @Override
    public Marks editMarks(Marks marks) {
        return null;
    }

    @Override
    public void deleteMarks(Marks marks) {

    }
}
