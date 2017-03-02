package com.sethomecompany.dao;

import com.sethomecompany.domain.Queue;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class QueueDAOImpl implements QueueDAO{
    private SessionFactory sessionFactory;

    @Override
    public List<Queue> getAllQueue() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue a where a.id=:id");
        List<Queue> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Queue> getAllStudentsByProfessorId(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue a where a.timeteable.professor.id=:id");
        query.setParameter("id", id);
        List<Queue> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Queue getQueueById(Integer queueId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue a where a.id=:id");
        query.setParameter("id", queueId);
        List<Queue> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Integer addQueue(Queue queue) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(queue);
        session.getTransaction().commit();
        return queue.getIdInQueue();
    }

    @Override
    public void updateQueue(Queue queue) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(queue);
        session.getTransaction().commit();
    }

    @Override
    public void deleteQueue(Queue queue) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(queue);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public void deleteQueueById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Queue a where a.id=:id");
        query.setParameter("id", id);
        List<Queue> list = query.list();
        session.delete(ifExists(list));
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Queue ifExists(List<Queue> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
