package com.genezis.dao;

import com.genezis.model.CommentToWork;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class CommentToWorkDAOImpl implements CommentToWorkDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveCommentToWork(CommentToWork commentToWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(commentToWork);
        session.getTransaction().commit();
    }

    @Override
    public List<CommentToWork> listCommentToWork() {
        return null;
    }

    @Override
    public CommentToWork getCommentToWorkById(int id) {
        return null;
    }

    @Override
    public CommentToWork editCommentToWork(CommentToWork commentToWork) {
        return null;
    }

    @Override
    public void deleteCommentToWork(CommentToWork commentToWork) {

    }
}
