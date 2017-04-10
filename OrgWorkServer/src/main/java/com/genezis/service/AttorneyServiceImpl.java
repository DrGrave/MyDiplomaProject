package com.genezis.service;

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

    @Override
    public void saveAttorney(Attorney attorney) {

    }

    @Override
    public Attorney getAttorney(int id) {
        return null;
    }

    @Override
    public Attorney editAttorney(Attorney attorney) {
        return null;
    }

    @Override
    public void deleteAttorney(Attorney attorney) {

    }

    @Override
    public Attorney ifExists(Attorney attorney) {
        return null;
    }
}
