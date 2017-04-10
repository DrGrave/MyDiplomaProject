package com.genezis.service;

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

    @Override
    public void saveInClass(InClass inClass) {

    }

    @Override
    public InClass getInClass(int id) {
        return null;
    }

    @Override
    public InClass editInClass(InClass inClass) {
        return null;
    }

    @Override
    public void deleteInClass(InClass inClass) {

    }

    @Override
    public InClass ifExists(InClass inClass) {
        return null;
    }
}
