package com.genezis;

import com.genezis.dao.*;
import com.genezis.model.Timeteable;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Vadim on 09.04.2017.
 */
@Transactional()
public class TimeteableDAOImplTest {
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
        Timeteable timeteable = new Timeteable();
        Date date = new Date();
        date.setTime(234141341);
        Time time = new Time(24);
        Long lon;
        timeteable.setDate(date);
        Calendar cal = Calendar.getInstance();
        date = cal.getTime();
        lon = date.getTime();
        time.setTime(lon);
        timeteable.setMyUser(userDAO.getUserById(1));
        timeteable.setSubject(subjectDAO.getSubject(1));
        timeteable.setTime(time);
        timeteable.setTimeToEnd(time);
        timeteable.setAuditory("ssd");
        timeteableDAO.saveTimeteable(timeteable);
    }

    @Test
    public void getTimeProfessorTime(){
//        Time time = new Time(13,24,34);
//        Date date = new Date();
//        Timeteable timeteable = timeteableDAO.getTimeteableByProfessorIdTime(1, time, date);
//        System.out.print(timeteable.getTime());
    }

    @Test
    public void getTimeteable(){
        Timeteable timeteable = timeteableDAO.getTimeteable(10);
        System.out.print(timeteable.getTime());
    }
    @Test
    public void edit()throws NoSuchAlgorithmException{
        Timeteable timeteable = timeteableDAO.getTimeteable(1);
        timeteable.setAuditory("Fadada");
        timeteableDAO.editTimeteable(timeteable);
    }
    @Test
    public void list()throws NoSuchAlgorithmException{
        List<Timeteable> list = timeteableDAO.listTimeteable();
        System.out.print(list);
    }
    @Test
    public void delete()throws NoSuchAlgorithmException{
        Timeteable timeteable = timeteableDAO.getTimeteable(1);
     //   timeteableDAO.deleteTimeteable(timeteable);
    }
}
