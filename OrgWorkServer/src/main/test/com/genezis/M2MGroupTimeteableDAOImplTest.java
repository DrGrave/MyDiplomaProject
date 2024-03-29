package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.InClass;
import com.genezis.model.M2MGroupTimeteable;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class M2MGroupTimeteableDAOImplTest {
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
    private M2MGroupTimeteableDAO m2mGroupTimeteableDAO = context.getBean(M2MGroupTimeteableDAO.class);

    @Test
    public void add()throws NoSuchAlgorithmException {
        M2MGroupTimeteable m2MGroupTimeteable = new M2MGroupTimeteable();
        m2MGroupTimeteable.setIdGroup(groupDAO.getGroupById(1));
        m2MGroupTimeteable.setIdTimeteable(timeteableDAO.getTimeteable(1));
        m2mGroupTimeteableDAO.saveM2MGroupTimeteable(m2MGroupTimeteable);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        M2MGroupTimeteable m2MGroupTimeteable = m2mGroupTimeteableDAO.getM2MGroupTimeteable(1);
        m2MGroupTimeteable.setIdGroup(groupDAO.getGroupById(2));
        m2mGroupTimeteableDAO.editM2MGroupTimeteable(m2MGroupTimeteable);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{

    }
    @Test
    public void delete()throws NoSuchAlgorithmException{

    }
}
