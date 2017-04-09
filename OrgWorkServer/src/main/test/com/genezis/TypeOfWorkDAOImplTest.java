package com.genezis;

import com.genezis.dao.TypeOfWorkDAO;

import com.genezis.model.TypeOfWork;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class TypeOfWorkDAOImplTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    TypeOfWorkDAO typeOfWorkDAO = context.getBean(TypeOfWorkDAO.class);
    @Test
    public void addTypeOfWork() throws NoSuchAlgorithmException {
        TypeOfWork typeOfWork = new TypeOfWork();
        typeOfWork.setNameTypeOfWOrk("Prev");
        typeOfWorkDAO.saveTypeOfWork(typeOfWork);
    }
}
