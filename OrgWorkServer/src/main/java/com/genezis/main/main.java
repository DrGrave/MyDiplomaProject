package com.genezis.main;

import java.util.List;

import com.genezis.dao.*;
import com.genezis.model.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;



class SpringHibernateMain {

    public static void main(String[] args) {

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


        TypeInClass typeInClass = new TypeInClass();
        typeInClass.setIdTypeInClass(0);
        typeInClass.setNameTypeInClass("do");
        TypeOfAttorney typeOfAttorney = new TypeOfAttorney();
        typeOfAttorney.setIdTypeOfAttorney(0);
        typeOfAttorney.setNameOfTypeAttorney("aa");

        TypeOfWork typeOfWork = new TypeOfWork();
        typeOfWork.setIdTypeOfWOrk(0);
        typeOfWork.setNameTypeOfWOrk("ga");

        Group group = new Group();
        group.setIdGroup(1);
        User user = new User();
        user.setIdUser(2);
        user.setUserName("ff");
        user.setUserSeccondname("ff");
        user.setUserSurname("ff");
        UserType person = new UserType();
        person.setNameUserType("Professor1");
        person.setIdUserType(1);
        user.setUserType(person);
        group.setIdUserStarosta(user);
        group.setNumberOfGroup("345123");
        Subject subject = new Subject();
        subject.setIdSubject(0);
        subject.setNameSubject("23");



        groupDAO.saveGroup(group);
        typeOfAttorneyDAO.saveTypeOfAttorney(typeOfAttorney);
        typeInClassDAO.saveTypeInClass(typeInClass);
        personDAO.saveUserType(person);
        subjectDAO.saveSubject(subject);
        System.out.println("Person::"+person);
       // personDAO.deleteUserType(person);
        List<UserType> list = personDAO.list();
        typeOfWorkDAO.saveTypeOfWork(typeOfWork);
        userDAO.saveUser(user);

        for(UserType p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close();
    }
}