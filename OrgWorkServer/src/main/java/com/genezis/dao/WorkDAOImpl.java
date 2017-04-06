package com.genezis.dao;

import com.genezis.model.Work;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.expression.spel.ast.QualifiedIdentifier;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class WorkDAOImpl implements WorkDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveWork(Work work) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(work);
        session.getTransaction().commit();
    }

    @Override
    public List<Work> listWork() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Work");
        List<Work> worksList = query.list();
        session.getTransaction().commit();
        return worksList;
    }

    @Override
    public Work getWork(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Work w where w.id=:id");
        query.setParameter("id", id);
        List<Work> list= query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Work editWork(Work work) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.refresh(work);
        session.getTransaction().commit();
        return work;
    }

    @Override
    public void deleteWork(Work work) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(work);
        session.getTransaction().commit();
    }

    private Work ifExists(List<Work> workList){
        if(workList.size() > 0){
            return workList.get(0);
        }else {
            return null;
        }
    }
}
