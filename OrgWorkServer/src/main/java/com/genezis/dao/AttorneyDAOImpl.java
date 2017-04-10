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

    @Override
    public Attorney ifExistsAttorney(Attorney attorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Attorney a where a.typeOfAttorney=:typeOfAttorney and a.subject=:subject and a.idMyUserProfessor=:professor and a.idMyUserStudent=:student");
        query.setParameter("typeOfAttorney", attorney.getTypeOfAttorney());
        query.setParameter("subject", attorney.getSubject());
        query.setParameter("professor", attorney.getIdMyUserProfessor());
        query.setParameter("student", attorney.getIdMyUserStudent());
        List<Attorney> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    private Attorney ifExists(List<Attorney> attorneys){
        if(attorneys.size() > 0){
            return attorneys.get(0);
        }else {
            return null;
        }
    }
}
