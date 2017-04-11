package com.genezis.service;

import com.genezis.dao.*;
import com.genezis.model.InClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("inClassService")
@Transactional
public class InClassServiceImpl implements InClassService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private InClassDAO inClassDAO = context.getBean(InClassDAO.class);

    @Override
    public void saveInClass(InClass inClass) {
        inClassDAO.saveInClass(inClass);
    }

    @Override
    public InClass getInClass(int id) {
        return inClassDAO.getInClass(id);
    }

    @Override
    public InClass editInClass(InClass inClass) {
        return inClassDAO.editInClass(inClass);
    }

    @Override
    public void deleteInClass(InClass inClass) {
        inClassDAO.deleteInClass(inClass);
    }

    @Override
    public InClass ifExists(InClass inClass) {
        return inClassDAO.ifExistsInClass(inClass);
    }
}
