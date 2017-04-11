package com.genezis.service;

import com.genezis.dao.*;
import com.genezis.model.Attorney;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("attorneyService")
@Transactional
public class AttorneyServiceImpl implements AttorneyService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    private AttorneyDAO attorneyDAO = context.getBean(AttorneyDAO.class);


    @Override
    public void saveAttorney(Attorney attorney) {
        attorneyDAO.saveAttorney(attorney);
    }

    @Override
    public Attorney getAttorney(int id) {
        return attorneyDAO.getAttorneyById(id);
    }

    @Override
    public Attorney editAttorney(Attorney attorney) {
        return attorneyDAO.editAttorney(attorney);
    }

    @Override
    public void deleteAttorney(Attorney attorney) {
        attorneyDAO.deleteAttorney(attorney);
    }

    @Override
    public Attorney ifExists(Attorney attorney) {
        return attorneyDAO.ifExistsAttorney(attorney);
    }
}
