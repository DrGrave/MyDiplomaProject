package com.genezis.dao;

import com.genezis.model.Attorney;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AttorneyDAOImpl implements AttorneyDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveAttorney(Attorney attorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(attorney);
        session.getTransaction().commit();
    }

    @Override
    public List<Attorney> listAttorney() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Attorney");
        List<Attorney> attorneys = query.list();
        session.getTransaction().commit();
        return attorneys;
    }

    @Override
    public Attorney getAttorneyById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Attorney a where a.id=:id");
        query.setParameter("id",id);
        List<Attorney> attorneys = query.list();
        session.getTransaction().commit();
        return ifExists(attorneys);
    }

    @Override
    public Attorney editAttorney(Attorney attorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(attorney);
        session.getTransaction().commit();
        return attorney;
    }

    @Override
    public void deleteAttorney(Attorney attorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(attorney);
        session.getTransaction().commit();
    }

    private Attorney ifExists(List<Attorney> attorneys){
        if(attorneys.size() > 0){
            return attorneys.get(0);
        }else {
            return null;
        }
    }
}
