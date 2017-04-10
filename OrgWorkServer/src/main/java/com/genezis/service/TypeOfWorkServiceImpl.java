package com.genezis.service;

import com.genezis.model.TypeOfWork;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("typeOfWorkService")
@Transactional
public class TypeOfWorkServiceImpl implements TypeOfWorkService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");


    @Override
    public void saveTypeOfWork(TypeOfWork typeOfWork) {

    }

    @Override
    public TypeOfWork getTypeOfWork(int id) {
        return null;
    }

    @Override
    public TypeOfWork editTypeOfWork(TypeOfWork typeOfWork) {
        return null;
    }

    @Override
    public void deleteTypeOfWork(TypeOfWork typeOfWork) {

    }

    @Override
    public TypeOfWork ifExists(TypeOfWork typeOfWork) {
        return null;
    }
}
