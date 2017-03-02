package com.sethomecompany.dao;

import com.sethomecompany.domain.Professor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class ProfessorDAOImpl implements ProfessorDAO{
    private SessionFactory sessionFactory;

    @Override
    public List<Professor> getAllProfessor() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Professor");
        List<Professor> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Professor getProfessorById(Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Professor a where a.id=:id");
        query.setParameter("id", userId);
        List<Professor> list = query.list();
        session.getTransaction().commit();
        return ifExists(list);
    }

    @Override
    public Integer addProfessor(Professor professor) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(professor);
        session.getTransaction().commit();
        return professor.getIdProfessor();
    }

    @Override
    public void updateProfessor(Professor professor) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(professor);
        session.getTransaction().commit();

    }

    @Override
    public void deleteProfessor(Professor professor) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(professor);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public void deleteProfessorById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Professor a where a.id=:id");
        query.setParameter("id", id);
        List<Professor> list = query.list();
        session.delete(ifExists(list));
        session.getTransaction().commit();

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Professor ifExists(List<Professor> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
