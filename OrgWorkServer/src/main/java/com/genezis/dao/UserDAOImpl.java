package com.genezis.dao;

import com.genezis.model.myUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class UserDAOImpl implements UserDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveUser(myUser myUser) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(myUser);
        session.getTransaction().commit();
    }

    @Override
    public List<myUser> list() {
        List<myUser> list;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from myuser");
        list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public myUser getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from myUser t where t.id=:id");
        query.setParameter("id", id);
        List<myUser> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public void deleteUser(myUser myUser) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(myUser);
        session.getTransaction().commit();
    }

    @Override
    public myUser editUser(myUser myUser) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.refresh(myUser);
        session.getTransaction().commit();
        return myUser;
    }

    private myUser ifExists(List<myUser> myUserList){
        if(myUserList.size() > 0){
            return myUserList.get(0);
        }else {
            return null;
        }
    }
}
