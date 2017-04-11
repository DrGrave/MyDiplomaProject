package com.genezis.service;

import com.genezis.dao.TypeInClassDAO;
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
    private TypeInClassDAO typeInClassDAO = context.getBean(TypeInClassDAO.class);

    @Override
    public void saveTypeInClass(TypeInClass typeInClass) {
        typeInClassDAO.saveTypeInClass(typeInClass);
    }

    @Override
    public TypeInClass getTypeInClass(int id) {
        return typeInClassDAO.getTypeInClass(id);
    }

    @Override
    public TypeInClass editTypeInClass(TypeInClass typeInClass) {
        return typeInClassDAO.editTypeInClass(typeInClass);
    }

    @Override
    public void deleteTypeInClass(TypeInClass typeInClass) {
        typeInClassDAO.deleteTypeInClass(typeInClass);
    }

    @Override
    public TypeInClass ifExists(TypeInClass typeInClass) {
        return typeInClassDAO.ifExistsTypeInClass(typeInClass);
    }
}
