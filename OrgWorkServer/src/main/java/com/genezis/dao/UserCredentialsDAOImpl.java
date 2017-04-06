package com.genezis.dao;

import com.genezis.model.UserCredentials;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class UserCredentialsDAOImpl implements UserCredentialsDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveUserCredential(UserCredentials userCredential) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userCredential);
        session.getTransaction().commit();
    }

    @Override
    public List<UserCredentials> listUserCredential() {
        return null;
    }

    @Override
    public UserCredentials getUserCredential(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserCredentials uc where uc.id=:id");
        query.setParameter("id", id);
        List<UserCredentials> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public UserCredentials editUserCredential(UserCredentials userCredential) {
        return null;
    }

    @Override
    public void deleteUserCredentials(UserCredentials userCredentials) {

    }

    private UserCredentials ifExists(List<UserCredentials> userCredentialsList){
        if(userCredentialsList.size() > 0){
            return userCredentialsList.get(0);
        }else {
            return null;
        }
    }
}
