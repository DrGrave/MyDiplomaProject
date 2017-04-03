package com.genezis.dao;

import org.hibernate.SessionFactory;

/**
 * Created by vadim on 03.04.17.
 */
public class InClassDAOImpl implements InClassDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
