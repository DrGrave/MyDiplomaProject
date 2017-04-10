package com.genezis.service;

import com.genezis.model.TypeInClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("typeInClassService")
@Transactional
public class TypeInClassServiceImpl implements TypeInClassService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void saveTypeInClass(TypeInClass typeInClass) {

    }

    @Override
    public TypeInClass getTypeInClass(int id) {
        return null;
    }

    @Override
    public TypeInClass editTypeInClass(TypeInClass typeInClass) {
        return null;
    }

    @Override
    public void deleteTypeInClass(TypeInClass typeInClass) {

    }

    @Override
    public TypeInClass ifExists(TypeInClass typeInClass) {
        return null;
    }
}
