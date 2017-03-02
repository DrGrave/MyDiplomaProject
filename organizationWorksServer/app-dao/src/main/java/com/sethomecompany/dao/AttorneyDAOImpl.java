package com.sethomecompany.dao;

import com.sethomecompany.domain.Attorney;
import com.sethomecompany.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class AttorneyDAOImpl implements AttorneyDAO {

    private SessionFactory sessionFactory;

    @Override
    public Integer addAttorney(Attorney attorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(attorney);
        session.getTransaction().commit();
        return attorney.getIdAttorney();
    }

    @Override
    public void deleteAttorney(Attorney attorney) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(attorney);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public Attorney getAttorney(Integer userID) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Attorney a where a.userAttorney.id=:id");
        query.setParameter("id", userID);
        List<Attorney> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Attorney ifExists(List<Attorney> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
