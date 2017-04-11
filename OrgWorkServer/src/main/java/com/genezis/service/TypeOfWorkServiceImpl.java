package com.genezis.service;

import com.genezis.dao.TypeOfWorkDAO;
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
    private TypeOfWorkDAO typeOfWorkDAO = context.getBean(TypeOfWorkDAO.class);

    @Override
    public void saveTypeOfWork(TypeOfWork typeOfWork) {
        typeOfWorkDAO.saveTypeOfWork(typeOfWork);
    }

    @Override
    public TypeOfWork getTypeOfWork(int id) {
        return typeOfWorkDAO.getTypeOfWork(id);
    }

    @Override
    public TypeOfWork editTypeOfWork(TypeOfWork typeOfWork) {
        return typeOfWorkDAO.editTypeOfWork(typeOfWork);
    }

    @Override
    public void deleteTypeOfWork(TypeOfWork typeOfWork) {
        typeOfWorkDAO.deleteTypeOfWork(typeOfWork);
    }

    @Override
    public TypeOfWork ifExists(TypeOfWork typeOfWork) {
        return typeOfWorkDAO.ifExistsTypeOfWork(typeOfWork);
    }
}
