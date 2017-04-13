package com.genezis.dao;

import com.genezis.model.M2MProfessorSubject;
import com.genezis.model.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
public class M2MProfessorSubjectDAOImpl implements M2MProfessorSubjectDAO {
    private SessionFactory sessionFactory;

    @Override
    public void saveM2MProfessorSubject(M2MProfessorSubject m2mProfessorSubject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(m2mProfessorSubject);
        session.getTransaction().commit();
    }

    @Override
    public List<M2MProfessorSubject> listM2MProfessorSubject() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from M2MProfessorSubject");
        List<M2MProfessorSubject> list = query.list();
        return list;
    }

    @Override
    public M2MProfessorSubject getM2MProfessorSubject(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from M2MProfessorSubject ps where  ps.id=:id");
        query.setParameter("id",id);
        List<M2MProfessorSubject> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public M2MProfessorSubject editM2MProfessorSubject(M2MProfessorSubject m2mProfessorSubject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(m2mProfessorSubject);
        session.getTransaction().commit();
        return m2mProfessorSubject;
    }

    @Override
    public void deleteM2MProfessorSubject(M2MProfessorSubject m2mProfessorSubject) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(m2mProfessorSubject);
        session.getTransaction().commit();
    }

    @Override
    public List<M2MProfessorSubject> getListSubjectsToProfessor(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from M2MProfessorSubject ps where  ps.idUser.id=:id");
        query.setParameter("id", id);
        List<M2MProfessorSubject> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private M2MProfessorSubject ifExists(List<M2MProfessorSubject> inClasses){
        if(inClasses.size() > 0){
            return inClasses.get(0);
        }else {
            return null;
        }
    }
}
