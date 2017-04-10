package com.genezis.service;

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

    @Override
    public void saveTypeOfAttorney(TypeOfAttorney typeOfAttorney) {

    }

    @Override
    public TypeOfAttorney getTypeOfAttorney(int id) {
        return null;
    }

    @Override
    public TypeOfAttorney editTypeOfAttorney(TypeOfAttorney typeOfAttorney) {
        return null;
    }

    @Override
    public void deleteTypeOfAttorney(TypeOfAttorney typeOfAttorney) {

    }

    @Override
    public TypeOfAttorney ifExists(TypeOfAttorney typeOfAttorney) {
        return null;
    }
}
