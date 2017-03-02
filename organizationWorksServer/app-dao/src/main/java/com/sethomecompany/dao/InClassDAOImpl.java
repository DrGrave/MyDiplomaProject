package com.sethomecompany.dao;

import com.sethomecompany.domain.InClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class InClassDAOImpl implements InClassDAO {
    private SessionFactory sessionFactory;

    @Override
    public Integer addInClass(InClass inClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(inClass);
        return inClass.getIdInClass();
    }

    @Override
    public void deleteInClass(InClass inClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(inClass);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public InClass getInClass(Integer userID) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from InClass a where a.userInClass.id=:id");
        query.setParameter("id", userID);
        List<InClass> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public List<InClass> getAllInClassFowUser(Integer userID) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from InClass a where a.userInClass.id=:id");
        query.setParameter("id", userID);
        List<InClass> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private InClass ifExists(List<InClass> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
