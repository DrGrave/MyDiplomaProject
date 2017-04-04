package com.genezis.dao;

import com.genezis.model.Queue;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class QueueDAOImpl implements QueueDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveQueue(Queue queue) {

    }

    @Override
    public List<Queue> listQueue() {
        return null;
    }

    @Override
    public Queue getQueue(int id) {
        return null;
    }

    @Override
    public Queue editQueue(Queue queue) {
        return null;
    }
}
