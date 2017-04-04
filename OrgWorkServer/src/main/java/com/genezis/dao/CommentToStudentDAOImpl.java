package com.genezis.dao;

import com.genezis.model.CommentToStudent;
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
}
