package com.genezis.service;

import com.genezis.dao.TypeOfAttorneyDAO;
import com.genezis.model.TypeOfAttorney;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("typeOfAttorneyService")
@Transactional
public class TypeOfAttorneyServiceImpl implements TypeOfAttorneyService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private TypeOfAttorneyDAO typeOfAttorneyDAO = context.getBean(TypeOfAttorneyDAO.class);
    @Override
    public void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        typeOfAttorneyDAO.saveTypeOfAttorney(typeOfAttorney);
    }

    @Override
    public TypeOfAttorney getTypeOfAttorney(int id) {
        return typeOfAttorneyDAO.getTypeOfAttorney(id);
    }

    @Override
    public TypeOfAttorney editTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        return typeOfAttorneyDAO.editTypeOfAttorney(typeOfAttorney);
    }

    @Override
    public void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        typeOfAttorneyDAO.deleteTypeOfAttorney(typeOfAttorney);
    }

    @Override
    public TypeOfAttorney ifExists(TypeOfAttorney typeOfAttorney) {
        return typeOfAttorneyDAO.ifExistsTypeOfAttorney(typeOfAttorney);
    }
}
