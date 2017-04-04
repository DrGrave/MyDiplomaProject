package com.genezis.dao;

import com.genezis.model.Subject;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class SubjectDAOImpl implements SubjectDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveSubject(Subject subject) {

    }

    @Override
    public List<Subject> listSubject() {
        return null;
    }

    @Override
    public Subject getSubject(int id) {
        return null;
    }

    @Override
    public Subject editSubject(Subject subject) {
        return null;
    }
}
