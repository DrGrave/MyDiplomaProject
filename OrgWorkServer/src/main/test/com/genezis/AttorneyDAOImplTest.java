package com.genezis;

import com.genezis.dao.AttorneyDAO;
import com.genezis.dao.SubjectDAO;
import com.genezis.dao.TypeOfAttorneyDAO;
import com.genezis.dao.UserDAO;
import com.genezis.model.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class AttorneyDAOImplTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    AttorneyDAO attorneyDAO = context.getBean(AttorneyDAO.class);
    UserDAO userDAO = context.getBean(UserDAO.class);
    TypeOfAttorneyDAO typeOfAttorneyDAO = context.getBean(TypeOfAttorneyDAO.class);
    SubjectDAO subjectDAO = context.getBean(SubjectDAO.class);

    @Test
    public void addAttorney() throws NoSuchAlgorithmException {
        Attorney attorney = new Attorney();
        MyUser myUser;
        MyUser myUser1;
        TypeOfAttorney typeOfAttorney;
        Subject subject;
        myUser = userDAO.getUserById(1);
        myUser1 = userDAO.getUserById(2);
        typeOfAttorney = typeOfAttorneyDAO.getTypeOfAttorney(1);
        subject = subjectDAO.getSubject(1);
        attorney.setIdMyUserProfessor(myUser);
        attorney.setIdMyUserStudent(myUser1);
        attorney.setSubject(subject);
        attorney.setTypeOfAttorney(typeOfAttorney);
        attorneyDAO.saveAttorney(attorney);
    }

    @Test
    public  void editAttorney()throws NoSuchAlgorithmException{
        Attorney attorney = new Attorney();
        attorney = attorneyDAO.getAttorneyById(1);
        MyUser myUser;
        myUser = userDAO.getUserById(3);
        attorney.setIdMyUserProfessor(myUser);
        attorneyDAO.editAttorney(attorney);
    }

    @Test
    public void deleteAttorney() throws NoSuchAlgorithmException{
        Attorney attorney = new Attorney();
        attorney = attorneyDAO.getAttorneyById(1);
        attorneyDAO.deleteAttorney(attorney);
    }

}
