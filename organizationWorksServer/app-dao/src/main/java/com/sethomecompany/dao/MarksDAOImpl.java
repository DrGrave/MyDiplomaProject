package com.sethomecompany.dao;

import com.sethomecompany.domain.Marks;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class MarksDAOImpl implements MarksDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<Marks> getAllMarks(Integer userID) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Marks a where a.userOfMark.id=:id");
        query.setParameter("id", userID);
        List<Marks> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Marks getMarkById(Integer markId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Marks a where a.id=:id");
        query.setParameter("id", markId);
        List<Marks> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Integer addMark(Marks marks) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(marks);
        session.getTransaction().commit();
        return marks.getIdMark();
    }

    @Override
    public void updateMark(Marks marks) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(marks);
        session.getTransaction().commit();
    }

    @Override
    public void deleteMark(Marks marks) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
       session.delete(marks);
        session.flush();
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    private Marks ifExists(List<Marks> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
