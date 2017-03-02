package com.sethomecompany.dao;

import com.sethomecompany.domain.TypeInClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class TypeInClassDAOImpl implements TypeInClassDAO{
    private SessionFactory sessionFactory;

    @Override
    public List<TypeInClass> getAllTypeInClass() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();Query query = session.createQuery("from TypeInClass");
        List<TypeInClass> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Integer addTypeInClass(TypeInClass typeInClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(typeInClass);
        session.getTransaction().commit();
        return typeInClass.getIdTypeinclass();
    }

    @Override
    public void deleteTypeInClass(TypeInClass typeInClass) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(typeInClass);
        session.flush();
        session.getTransaction().commit();
    }

    @Override
    public TypeInClass getTypeInClass(Integer idTypeInClass) {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private TypeInClass ifExists(List<TypeInClass> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
