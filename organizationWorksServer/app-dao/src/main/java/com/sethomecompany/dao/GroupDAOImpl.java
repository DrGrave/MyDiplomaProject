package com.sethomecompany.dao;

import com.sethomecompany.domain.Group;
import com.sethomecompany.domain.UserCredential;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 11.12.2016.
 */
public class GroupDAOImpl implements GroupDAO {
    private SessionFactory sessionFactory;

    @Override
    public Integer addGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        group.setIdGroup(1);
        group.setNumberOfGroup("2313");
        group.setStudentStarosta(1);
        session.save(group);
        session.getTransaction().commit();
        return group.getIdGroup();
    }

    @Override
    public void deleteGroup(Group group) {

    }

    @Override
    public Group getGroup(Integer index) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Group g where g.idGroup=:idIndex");
        query.setParameter("idIndex", index);
        List<Group> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    private Group ifExists(List<Group> userList){
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
