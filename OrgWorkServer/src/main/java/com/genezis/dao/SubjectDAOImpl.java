package com.genezis.dao;

import com.genezis.model.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class SubjectDAOImpl implements SubjectDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(subject);
        session.getTransaction().commit();
    }

    @Override
    public List<Subject> listSubject() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subject");
        List<Subject> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Subject getSubject(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subject s where s.id=:id");
        query.setParameter("id",id);
        List<Subject> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Subject editSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(subject);
        session.getTransaction().commit();
        return subject;
    }

    @Override
    public void deleteSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(subject);
        session.getTransaction().commit();
    }

    @Override
    public Subject ifExistsSubject(Subject subject) {
        return null;
    }

    private Subject ifExists(List<Subject> subjects){
        if(subjects.size() > 0){
            return subjects.get(0);
        }else {
            return null;
        }
    }
}
