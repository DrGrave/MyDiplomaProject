package com.sethomecompany.dao;

import com.sethomecompany.domain.TypeOfwork;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class TypeOfWorkDAOImpl implements TypeOfWorkDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<TypeOfwork> getAllTypeOfwork() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypeOfwork a where a.id=:id");
        List<TypeOfwork> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Integer addTypeOfwork(TypeOfwork typeOfwork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(typeOfwork);
        session.getTransaction().commit();
        return typeOfwork.getIdTypeOfWork();
    }

    @Override
    public void deleteTypeOfwork(TypeOfwork typeOfwork) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(typeOfwork);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public TypeOfwork getTypeOfwork(Integer idTypeOfwork) {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private TypeOfwork ifExists(List<TypeOfwork> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
