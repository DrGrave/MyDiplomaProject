package com.genezis.dao;

import com.genezis.model.CommentToWork;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from CommentToWork");
        List<CommentToWork>  commentToWorks = query.list();
        session.getTransaction().commit();
        return commentToWorks;
    }

    @Override
    public CommentToWork getCommentToWorkById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from CommentToWork ctw where ctw.id=:id");
        query.setParameter("id",id);
        List<CommentToWork> commentToWorks = query.list();
        session.getTransaction().commit();
        return ifExists(commentToWorks);
    }

    @Override
    public CommentToWork editCommentToWork(CommentToWork commentToWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(commentToWork);
        session.getTransaction().commit();
        return commentToWork;
    }

    @Override
    public void deleteCommentToWork(CommentToWork commentToWork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(commentToWork);
        session.getTransaction().commit();
    }

    @Override
    public List<CommentToWork> getListForUserByWork(int idWork, int idUser) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from  CommentToWork ctw where ctw.student.id=:idUser and ctw.work.id=:idWork");
        query.setParameter("idUser", idUser);
        query.setParameter("idWork", idWork);
        List<CommentToWork> commentToWorks = query.list();
        session.getTransaction().commit();
        return commentToWorks;
    }

    @Override
    public CommentToWork ifExistsCommentToWork(CommentToWork commentToWork) {
        return null;
    }

    private CommentToWork ifExists(List<CommentToWork> commentToWorks){
        if(commentToWorks.size() > 0){
            return commentToWorks.get(0);
        }else {
            return null;
        }
    }
}
