package com.genezis.dao;

import com.genezis.model.CommentToStudent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from CommentToStudent");
        List<CommentToStudent> commentToStudents = query.list();
        session.getTransaction().commit();
        return commentToStudents;
    }

    @Override
    public CommentToStudent getCommentToStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from CommentToStudent cts where cts.id=:id");
        query.setParameter("id",id);
        List<CommentToStudent> commentToStudents = query.list();
        session.getTransaction().commit();
        return ifExists(commentToStudents);
    }

    @Override
    public CommentToStudent editCommentToStudent(CommentToStudent commentToStudent) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(commentToStudent);
        session.getTransaction().commit();
        return commentToStudent;
    }

    @Override
    public void deleteCommentToStudent(CommentToStudent commentToStudent) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(commentToStudent);
        session.getTransaction().commit();
    }

    @Override
    public CommentToStudent ifExistsCommentToSudent(CommentToStudent commentToStudent) {
        return null;
    }

    private CommentToStudent ifExists(List<CommentToStudent> commentToStudents){
        if(commentToStudents.size() > 0){
            return commentToStudents.get(0);
        }else {
            return null;
        }
    }
}
