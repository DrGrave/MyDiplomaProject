package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.InClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class InClassDAOImplTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    UserTypeDAO personDAO = context.getBean(UserTypeDAO.class);
    GroupDAO groupDAO = context.getBean(GroupDAO.class);
    UserDAO userDAO = context.getBean(UserDAO.class);
    AttorneyDAO attorneyDAO = context.getBean(AttorneyDAO.class);
    CommentToWorkDAO commentToWorkDAO = context.getBean(CommentToWorkDAO.class);
    CommentToStudentDAO commentToStudentDAO = context.getBean(CommentToStudentDAO.class);
    InClassDAO inClassDAO = context.getBean(InClassDAO.class);
    MarksDAO marksDAO = context.getBean(MarksDAO.class);
    QueueDAO queueDAO = context.getBean(QueueDAO.class);
    SubjectDAO subjectDAO = context.getBean(SubjectDAO.class);
    TimeteableDAO timeteableDAO = context.getBean(TimeteableDAO.class);
    TypeInClassDAO typeInClassDAO = context.getBean(TypeInClassDAO.class);
    TypeOfAttorneyDAO typeOfAttorneyDAO = context.getBean(TypeOfAttorneyDAO.class);
    TypeOfWorkDAO typeOfWorkDAO = context.getBean(TypeOfWorkDAO.class);
    UserCredentialsDAO userCredentialsDAO = context.getBean(UserCredentialsDAO.class);
    WorkDAO workDAO = context.getBean(WorkDAO.class);

    @Test
    public void add()throws NoSuchAlgorithmException {
        InClass inClass = new InClass();
        inClass.setMyUser(userDAO.getUserById(1));
        inClass.setTimeteable(timeteableDAO.getTimeteable(1));
        inClass.setTypeInClass(typeInClassDAO.getTypeInClass(1));
        inClassDAO.saveInClass(inClass);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        InClass inClass = inClassDAO.getInClass(1);
        inClass.setMyUser(userDAO.getUserById(3));
        inClassDAO.editInClass(inClass);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{
        List<InClass> list = inClassDAO.listInClass();
        System.out.print(list);
    }
    @Test
    public void delete()throws NoSuchAlgorithmException{
        InClass inClass = inClassDAO.getInClass(1);
     //   inClassDAO.deleteInClass(inClass);
    }
}
