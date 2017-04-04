package com.genezis.dao;

import com.genezis.model.UserCredentials;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class UserCredentialDAOImpl implements UserCredentialDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveUserCredential(UserCredentials userCredential) {

    }

    @Override
    public List<UserCredentials> listUserCredential() {
        return null;
    }

    @Override
    public UserCredentials getUserCredential(int id) {
        return null;
    }

    @Override
    public UserCredentials editUserCredential(UserCredentials userCredential) {
        return null;
    }
}
