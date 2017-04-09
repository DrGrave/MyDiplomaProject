package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.Marks;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class MarksDAOImplTest {
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
        Marks marks = new Marks();
        marks.setMark(10);
        marks.setMyUser(userDAO.getUserById(1));
        marks.setTimeteable(timeteableDAO.getTimeteable(1));
        marks.setWork(workDAO.getWork(1));
        marksDAO.saveMarks(marks);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        Marks marks = marksDAO.getMarks(1);
        marks.setMark(8);
        marksDAO.editMarks(marks);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{
        List<Marks> list = marksDAO.listMarks();
        System.out.print(list);
    }
    @Test
    public void delete()throws NoSuchAlgorithmException{
        Marks marks = marksDAO.getMarks(1);
        marksDAO.deleteMarks(marks);
    }
}
