package com.sethomecompany.dao;

import com.sethomecompany.domain.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class SubjectDAOImpl implements SubjectDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<Subject> getAllSubject() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subject");
        List<Subject> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Subject> getAllSubjectByProfessorId(Integer id) {

        return null;//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    @Override
    public Subject getSubjectById(Integer subjectId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subject a where a.id=:id");
        query.setParameter("id", subjectId);
        List<Subject> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Integer addSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(subject);
        session.getTransaction().commit();
        return subject.getIdSubject();
    }

    @Override
    public void updateSubject(Subject subject) {

    }

    @Override
    public void deleteSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(subject);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public void deleteSubjectById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue a where a.id=:id");
        query.setParameter("id", id);
        List<Subject> list = query.list();
        session.delete(ifExists(list));
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    private Subject ifExists(List<Subject> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
