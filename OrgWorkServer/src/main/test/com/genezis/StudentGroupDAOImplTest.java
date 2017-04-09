package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.StudentGroup;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class StudentGroupDAOImplTest {
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
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setIdMyUserStarosta(userDAO.getUserById(1));
        studentGroup.setNumberOfGroup("Fafafaf");
        groupDAO.saveGroup(studentGroup);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        StudentGroup studentGroup = groupDAO.getGroupById(1);
        studentGroup.setNumberOfGroup("EDITTEST");
        groupDAO.editGroup(studentGroup);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{
        List<StudentGroup> studentGroups = groupDAO.list();
        System.out.print(studentGroups);
    }
    @Test
    public void delete()throws NoSuchAlgorithmException{
        StudentGroup studentGroup = groupDAO.getGroupById(1);
     //   groupDAO.deleteGroup(studentGroup);
    }
}
