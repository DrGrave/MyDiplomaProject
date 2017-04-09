package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.Work;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class WorkDAOImplTest {
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
        Work work = new Work();
        work.setMyUser(userDAO.getUserById(1));
        work.setNameOfWork("ff");
        work.setNumberOfWOrk("1");
        work.setTextOfWork("dsfsf");
        work.setTypeOfWork(typeOfWorkDAO.getTypeOfWork(1));
        work.setSubject(subjectDAO.getSubject(1));
        workDAO.saveWork(work);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        Work work;
        work = workDAO.getWork(1);
        work.setTextOfWork("thiswork");
        workDAO.editWork(work);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{
        List<Work> works = workDAO.listWork();
        System.out.print(works);
    }
    @Test
    public void delete()throws NoSuchAlgorithmException{
        Work work = workDAO.getWork(1);
      //  workDAO.deleteWork(work);
    }
}
