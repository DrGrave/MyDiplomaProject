package com.genezis.service;

import com.genezis.dao.WorkDAO;
import com.genezis.model.Work;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vadim on 03.04.17.
 */
public class WorkServiceImpl implements WorkService {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    WorkDAO workDAO = context.getBean(WorkDAO.class);
    @Override
    public void saveWork(Work work) {
    workDAO.saveWork(work);
    }
}
