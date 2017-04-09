package com.genezis.dao;

import com.genezis.model.M2MStudentWork;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
public class M2MStudentWorkDAOImpl implements M2MStudentWorkDAO {
    private SessionFactory sessionFactory;

    @Override
    public void saveM2MStudentWork(M2MStudentWork m2mStudentWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(m2mStudentWork);
        session.getTransaction().commit();
    }

    @Override
    public List<M2MStudentWork> listM2MStudentWork() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from M2MStudentWork");
        List<M2MStudentWork> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public M2MStudentWork getM2MStudentWork(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from M2MStudentWork sw where sw.id=:id");
        query.setParameter("id",id);
        List<M2MStudentWork> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public M2MStudentWork editM2MStudentWork(M2MStudentWork m2mStudentWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(m2mStudentWork);
        session.getTransaction().commit();
        return m2mStudentWork;
    }

    @Override
    public void deleteM2MStudentWork(M2MStudentWork m2mStudentWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(m2mStudentWork);
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private M2MStudentWork ifExists(List<M2MStudentWork> inClasses){
        if(inClasses.size() > 0){
            return inClasses.get(0);
        }else {
            return null;
        }
    }
}
