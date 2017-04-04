package com.genezis.dao;

import com.genezis.model.CommentToStudent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class CommentToStudentDAOImpl implements CommentToStudentDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveCommentToStudent(CommentToStudent commentToStudent) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(commentToStudent);
        session.getTransaction().commit();
    }

    @Override
    public List<CommentToStudent> listCommentToStudent() {
        return null;
    }

    @Override
    public CommentToStudent getCommentToStudentById(int id) {
        return null;
    }

    @Override
    public CommentToStudent editCommentToStudent(CommentToStudent commentToStudent) {
        return null;
    }

    @Override
    public void deleteCommentToStudent(CommentToStudent commentToStudent) {

    }
}
