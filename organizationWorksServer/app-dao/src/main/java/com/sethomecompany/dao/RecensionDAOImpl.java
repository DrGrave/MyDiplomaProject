package com.sethomecompany.dao;

import com.sethomecompany.domain.Recension;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class RecensionDAOImpl implements RecensionDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<Recension> getAllRecension() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Recension");
        List<Recension> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Recension> getAllStudentsByQueueId(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Recension a where a.queue.id=:id");
        query.setParameter("id", id);
        List<Recension> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Recension getRecensionById(Integer recensionId) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Recension a where a.id=:id");
        query.setParameter("id", recensionId);
        List<Recension> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Integer addRecension(Recension recension) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(recension);
        session.getTransaction().commit();
        return recension.getIdRecension();
    }

    @Override
    public void updateRecension(Recension recension) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(recension);
        session.getTransaction().commit();
    }

    @Override
    public void deleteRecension(Recension recension) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(recension);
        session.getTransaction().commit();
    }

    @Override
    public void deleteRecensionById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Recension a where a.id=:id");
        query.setParameter("id", id);
        List<Recension> list = query.list();
        session.delete(ifExists(list));
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    private Recension ifExists(List<Recension> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
