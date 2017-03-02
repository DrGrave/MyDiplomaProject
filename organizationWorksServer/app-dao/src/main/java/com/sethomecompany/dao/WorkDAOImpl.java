package com.sethomecompany.dao;

import com.sethomecompany.domain.Work;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Vadim on 12.12.2016.
 */
public class WorkDAOImpl implements WorkDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<Work> getAllWork() {
        return null;
    }

    @Override
    public List<Work> getAllWorkBySubjectId(Integer id) {
        return null;
    }

    @Override
    public Work getWorkById(Integer workId) {
        return null;
    }

    @Override
    public Integer addWork(Work work) {
        return null;
    }

    @Override
    public void updateWork(Work work) {

    }

    @Override
    public void deleteWork(Work work) {

    }

    @Override
    public void deleteWorkById(Integer id) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Work ifExists(List<Work> userList){
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
