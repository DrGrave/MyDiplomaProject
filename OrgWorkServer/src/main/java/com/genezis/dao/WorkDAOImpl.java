package com.genezis.dao;

import com.genezis.model.Work;
import org.hibernate.SessionFactory;

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

    }

    @Override
    public List<Work> listWork() {
        return null;
    }

    @Override
    public Work getWork(int id) {
        return null;
    }

    @Override
    public Work editWork(Work work) {
        return null;
    }
}
