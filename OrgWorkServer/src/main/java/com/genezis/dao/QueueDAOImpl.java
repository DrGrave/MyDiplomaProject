package com.genezis.dao;

import com.genezis.model.Queue;
import com.genezis.model.Work;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(queue);
        session.getTransaction().commit();
    }

    @Override
    public List<Queue> listQueue() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue");
        List<Queue> queues = query.list();
        session.getTransaction().commit();
        return queues;
    }

    @Override
    public Queue getQueue(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue q where q.id=:id");
        query.setParameter("id",id);
        List<Queue> queues = query.list();
        session.getTransaction().commit();
        return ifExists(queues);
    }

    @Override
    public Queue editQueue(Queue queue) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(queue);
        session.getTransaction().commit();
        return queue;
    }

    @Override
    public void deleteQuee(Queue queue) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(queue);
        session.getTransaction().commit();
    }

    @Override
    public List<Queue> listQueueProfessorById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue q where q.timeteable.MyUser.id=:id");
        query.setParameter("id", id);
        List<Queue> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Work> listOfWorksToStudent(int id, int prof) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue q where q.MyUser.id=:id and q.timeteable.MyUser.id=:prof");
        query.setParameter("id", id);
        query.setParameter("prof", prof);
        List<Queue> list = query.list();
        session.getTransaction().commit();
        List<Work> works = new ArrayList<>();
        for (Queue queue : list){
            works.add(queue.getWork());
        }
        return works;
    }

    @Override
    public Queue ifExistsQueue(Queue queue) {
        return null;
    }

    private Queue ifExists(List<Queue> queues){
        if(queues.size() > 0){
            return queues.get(0);
        }else {
            return null;
        }
    }
}
