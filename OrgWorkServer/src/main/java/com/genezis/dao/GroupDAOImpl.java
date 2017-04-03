package com.genezis.dao;

import com.genezis.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public class GroupDAOImpl implements GroupDAO{

    private SessionFactory sessionFactory;

    @Override
    public void saveGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(group);
        session.getTransaction().commit();
    }

    @Override
    public List<Group> list() {
        return null;
    }

    @Override
    public Group getGroupById() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
