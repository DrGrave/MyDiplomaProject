package com.genezis.dao;

import com.genezis.model.MyUser;
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
    public void saveUser(MyUser MyUser) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(MyUser);
        session.getTransaction().commit();
    }

    @Override
    public List<MyUser> list() {
        List<MyUser> list;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from MyUser");
        list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public MyUser getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from MyUser t where t.id=:id");
        query.setParameter("id", id);
        List<MyUser> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public void deleteUser(MyUser MyUser) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(MyUser);
        session.getTransaction().commit();
    }

    @Override
    public MyUser editUser(MyUser MyUser) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(MyUser);
        session.getTransaction().commit();
        return MyUser;
    }

    private MyUser ifExists(List<MyUser> myUserList){
        if(myUserList.size() > 0){
            return myUserList.get(0);
        }else {
            return null;
        }
    }
}
