package com.genezis.dao;

import com.genezis.model.Marks;
import org.hibernate.Query;
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
    public List<Marks> getListMarks(int idUser, int idSubject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Marks m where m.MyUser.id=:idUser and m.work.subject.idSubject=:idSubject");
        query.setParameter("idUser", idUser);
        query.setParameter("idSubject", idSubject);
        List<Marks> marksList = query.list();
        session.getTransaction().commit();
        return marksList;
    }

    @Override
    public List<Marks> listMarks() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Marks");
        List<Marks> marks = query.list();
        session.getTransaction().commit();
        return marks;
    }

    @Override
    public Marks getMarks(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Marks m where m.id=:id");
        query.setParameter("id",id);
        List<Marks> marks = query.list();
        session.getTransaction().commit();
        return ifExists(marks);
    }

    @Override
    public Marks editMarks(Marks marks) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(marks);
        session.getTransaction().commit();
        return marks;
    }

    @Override
    public void deleteMarks(Marks marks) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(marks);
        session.getTransaction().commit();
    }

    @Override
    public Marks ifExistsMarks(Marks marks) {
        return null;
    }

    private Marks ifExists(List<Marks> marks){
        if(marks.size() > 0){
            return marks.get(0);
        }else {
            return null;
        }
    }
}
