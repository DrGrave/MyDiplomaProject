package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.M2MGroupTimeteable;
import com.genezis.model.M2MProfessorSubject;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class M2MPofessorSubjectDAOImplTest {
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
    M2MGroupTimeteableDAO m2mGroupTimeteableDAO = context.getBean(M2MGroupTimeteableDAO.class);
    M2MProfessorSubjectDAO m2mProfessorSubjectDAO = context.getBean(M2MProfessorSubjectDAO.class);

    @Test
    public void add()throws NoSuchAlgorithmException {
        M2MProfessorSubject professorSubject = new M2MProfessorSubject();
        professorSubject.setIdUser(userDAO.getUserById(1));
        professorSubject.setIdSubject(subjectDAO.getSubject(1));
        m2mProfessorSubjectDAO.saveM2MProfessorSubject(professorSubject);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        M2MProfessorSubject m2MProfessorSubject = m2mProfessorSubjectDAO.getM2MProfessorSubject(1);
        m2MProfessorSubject.setIdSubject(subjectDAO.getSubject(2));
        m2mProfessorSubjectDAO.editM2MProfessorSubject(m2MProfessorSubject);
    }

    @Test
    public void getListOfSubjects(){
        List<M2MProfessorSubject> m2MProfessorSubject = m2mProfessorSubjectDAO.getListSubjectsToProfessor(1);
        System.out.print(m2MProfessorSubject);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{

    }
    @Test
    public void delete()throws NoSuchAlgorithmException{

    }
}
