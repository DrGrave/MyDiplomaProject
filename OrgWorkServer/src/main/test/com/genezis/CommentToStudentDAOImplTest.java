package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.CommentToStudent;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class CommentToStudentDAOImplTest {
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
    public void add()throws NoSuchAlgorithmException{
        CommentToStudent commentToStudent = new CommentToStudent();
        commentToStudent.setProfessor(userDAO.getUserById(1));
        commentToStudent.setStudent(userDAO.getUserById(3));
        commentToStudent.setTextOfComment("FFF");
        commentToStudentDAO.saveCommentToStudent(commentToStudent);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        CommentToStudent commentToStudent;
        commentToStudent = commentToStudentDAO.getCommentToStudentById(1);
        commentToStudent.setProfessor(userDAO.getUserById(4));
        commentToStudent.setTextOfComment("Aass");
        commentToStudentDAO.editCommentToStudent(commentToStudent);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{
        List<CommentToStudent> commentToStudents;
        commentToStudents = commentToStudentDAO.listCommentToStudent();
        System.out.print(commentToStudents.get(1));
    }
    @Test
    public void delete()throws NoSuchAlgorithmException{
        CommentToStudent commentToStudent;
        commentToStudent = commentToStudentDAO.getCommentToStudentById(1);
        commentToStudentDAO.deleteCommentToStudent(commentToStudent);
    }
}
