package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.M2MGroupTimeteable;
import com.genezis.model.M2MStudentWork;
import com.genezis.model.Subject;
import com.genezis.model.TypeOfAcceptWork;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class M2MStudentWorkDAOImplTest {
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
    M2MStudentWorkDAO m2mStudentWorkDAO = context.getBean(M2MStudentWorkDAO.class);
    TypeOfAccaptWorkDAO typeOfAccaptWorkDAO = context.getBean(TypeOfAccaptWorkDAO.class);

    @Test
    public void add()throws NoSuchAlgorithmException {
        M2MStudentWork m2MStudentWork = new M2MStudentWork();
        TypeOfAcceptWork typeOfAcceptWork = new TypeOfAcceptWork();
        typeOfAcceptWork.setNameOfAccaptWork("Accapt");
        typeOfAccaptWorkDAO.saveTypeOfAccaptWork(typeOfAcceptWork);
        m2MStudentWork.setIdOfAccaptWork(typeOfAcceptWork);
        m2MStudentWork.setIdOfWork(workDAO.getWork(1));
        m2MStudentWork.setIdUser(userDAO.getUserById(1));
        m2mStudentWorkDAO.saveM2MStudentWork(m2MStudentWork);
    }

    @Test
    public void edit()throws NoSuchAlgorithmException{
        M2MStudentWork m2MStudentWork = m2mStudentWorkDAO.getM2MStudentWork(1);
        m2MStudentWork.setIdOfWork(workDAO.getWork(3));
        m2mStudentWorkDAO.editM2MStudentWork(m2MStudentWork);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{

    }

    @Test
    public  void listSubjects(){

        List<M2MStudentWork> list = m2mStudentWorkDAO.getListSubjectsToWorksStudent(1);
        System.out.print(list);
    }

    @Test
    public void delete()throws NoSuchAlgorithmException{

    }
}
