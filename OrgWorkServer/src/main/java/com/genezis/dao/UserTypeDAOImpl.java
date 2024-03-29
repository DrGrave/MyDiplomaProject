package com.genezis.dao;

import com.genezis.model.UserType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class UserTypeDAOImpl implements UserTypeDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserType getUserTypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserType t where t.id=:id");
        query.setParameter("id", id);
        List<UserType> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public void saveUserType(UserType userType) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userType);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserType> list() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserType");
        List<UserType> userTypes = query.list();
        session.getTransaction().commit();
        return userTypes;
    }

    @Override
    public void deleteUserType(UserType userType) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(userType);
        session.getTransaction().commit();
    }

    @Override
    public UserType editUserType(UserType userType) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(userType);
        session.getTransaction().commit();
        return userType;
    }

    @Override
    public UserType ifExistsUserType(UserType userType) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserType ut where ut.nameUserType=:nameUserType");
        query.setParameter("nameUserType",userType.getNameUserType());
        List<UserType> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    private UserType ifExists(List<UserType> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
