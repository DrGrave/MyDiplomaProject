package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.MyUserCredentials;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class MyUserCredentialsDAOImplTest {
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
        MyUserCredentials myUserCredentials = new MyUserCredentials();
        myUserCredentials.setMyUser(userDAO.getUserById(1));
        myUserCredentials.setUserLogin("Login");
        myUserCredentials.setUserPassword("Password");
        userCredentialsDAO.saveUserCredential(myUserCredentials);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        MyUserCredentials myUserCredentials = userCredentialsDAO.getUserCredential(1);
        myUserCredentials.setUserLogin("TestEdit");
        userCredentialsDAO.editUserCredential(myUserCredentials);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{
        List<MyUserCredentials> myUserCredentials = userCredentialsDAO.listUserCredential();
        System.out.print(myUserCredentials);
    }
    @Test
    public void delete()throws NoSuchAlgorithmException{
        MyUserCredentials myUserCredentials = userCredentialsDAO.getUserCredential(1);
    //    userCredentialsDAO.deleteUserCredentials(myUserCredentials);
    }
}
