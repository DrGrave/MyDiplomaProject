package com.genezis.dao;

import com.genezis.model.UserType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class UserTypeDAOImpl implements UserTypeDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserType getUserTypeById(int id) {
        return null;
    }

    @Override
    public void saveUserType(UserType userType) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userType);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserType> list() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserType");
        List<UserType> userTypes = query.list();
        session.getTransaction().commit();
        return userTypes;
    }
}
