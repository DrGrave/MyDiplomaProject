package com.sethomecompany.dao;

import com.sethomecompany.domain.User;
import com.sethomecompany.domain.UserCredential;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 12.11.2016.
 */
public class UserCredentialDAOImpl implements UserCredentialDAO{

    private SessionFactory sessionFactory;

    @Override
    public Integer addCredential(UserCredential userCredential) throws NoSuchAlgorithmException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        userCredential.setPassword(doHashSum(userCredential.getPassword()));
       // session.save(userCredential.getUser());
        session.save(userCredential);
        session.getTransaction().commit();
        return userCredential.getIdUserCredential();
    }

    @Override
    public void deleteUserCredential(UserCredential userCredential) {
    Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(userCredential);
        //session.delete(userCredential.getUser());
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public UserCredential getUserIfExist(String login, String password) throws NoSuchAlgorithmException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        password = doHashSum(password);
        Query query = session.createQuery("from UserCredential u where u.login=:login and u.password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<UserCredential> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public UserCredential getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserCredential u where u.login=:login");
        query.setParameter("login", login);
        List<UserCredential> list = query.list();
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

    private UserCredential ifExists(List<UserCredential> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
