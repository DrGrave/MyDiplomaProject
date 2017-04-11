package com.genezis.dao;

import com.genezis.model.StudentGroup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class GroupDAOImpl implements GroupDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void saveGroup(StudentGroup studentGroup) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(studentGroup);
        session.getTransaction().commit();
    }

    @Override
    public List<StudentGroup> list() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from StudentGroup");
        List<StudentGroup> studentGroups = query.list();
        session.getTransaction().commit();
        return studentGroups;
    }

    @Override
    public StudentGroup getGroupById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from StudentGroup sg where  sg.id=:id");
        query.setParameter("id",id);
        List<StudentGroup> studentGroups = query.list();
        session.getTransaction().commit();
        return ifExists(studentGroups);
    }

    @Override
    public StudentGroup editGroup(StudentGroup studentGroup) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(studentGroup);
        session.getTransaction().commit();
        return studentGroup;
    }

    @Override
    public void deleteGroup(StudentGroup studentGroup) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(studentGroup);
        session.getTransaction().commit();
    }

    @Override
    public StudentGroup ifExistsStudentGroup(StudentGroup studentGroup) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from StudentGroup sg ");
        return null;
    }

    private StudentGroup ifExists(List<StudentGroup> studentGroups){
        if(studentGroups.size() > 0){
            return studentGroups.get(0);
        }else {
            return null;
        }
    }
}
