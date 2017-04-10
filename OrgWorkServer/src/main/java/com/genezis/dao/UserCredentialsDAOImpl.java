package com.genezis.dao;

import com.genezis.model.MyUserCredentials;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public void saveUserCredential(MyUserCredentials userCredential) throws NoSuchAlgorithmException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            userCredential.setUserPassword(doHashSum(userCredential.getUserPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        session.save(userCredential);
        session.getTransaction().commit();
    }

    @Override
    public List<MyUserCredentials> listUserCredential() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from MyUserCredentials");
        List<MyUserCredentials> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public MyUserCredentials getUserCredential(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from MyUserCredentials uc where uc.id=:id");
        query.setParameter("id", id);
        List<MyUserCredentials> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public MyUserCredentials editUserCredential(MyUserCredentials userCredential) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(userCredential);
        session.getTransaction().commit();
        return userCredential;
    }

    @Override
    public void deleteUserCredentials(MyUserCredentials myUserCredentials) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(myUserCredentials);
        session.getTransaction().commit();
    }

    @Override
    public MyUserCredentials getUserCredentialsByLP(String login, String password) throws NoSuchAlgorithmException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            password = doHashSum(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Query query = session.createQuery("from MyUserCredentials u where u.userLogin=:login and u.userPassword=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<MyUserCredentials> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    private String doHashSum(String password) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes());
        StringBuffer sb = new StringBuffer();
        byte byteData[] = m.digest();
        for (byte aByteData : byteData) {
            sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println("Текст в шестнадцатеричном виде : " + sb.toString());
        return sb.toString();
    }

    @Override
    public MyUserCredentials ifExistsMyUserCred(MyUserCredentials myUserCredentials) {
        return null;
    }

    private MyUserCredentials ifExists(List<MyUserCredentials> myUserCredentialsList){
        if(myUserCredentialsList.size() > 0){
            return myUserCredentialsList.get(0);
        }else {
            return null;
        }
    }
}
