package com.genezis.service;

import com.genezis.dao.WorkDAO;
import com.genezis.model.Work;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */

@Service("workService")
@Transactional
public class WorkServiceImpl implements WorkService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private WorkDAO workDAO = context.getBean(WorkDAO.class);
    @Override
    public void saveWork(Work work) {
    workDAO.saveWork(work);
    }

    @Override
    public Work editWork(Work work) {
        return workDAO.editWork(work);
    }

    @Override
    public void deleteWork(Work work) {
        workDAO.deleteWork(work);
    }

    @Override
    public Work ifExistsWork(Work work) {
        return workDAO.ifExistsWork(work);
    }

    @Override
    public Work getWorkById(int id) {
        return workDAO.getWork(id);
    }
}
