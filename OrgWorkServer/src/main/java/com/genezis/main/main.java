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
        myUser myUser = new myUser();
        myUser.setIdUser(2);
        myUser.setUserName("ff");
        myUser.setUserSeccondname("ff");
        myUser.setUserSurname("ff");
        UserType person = new UserType();
        person.setNameUserType("Professor1");
        person.setIdUserType(1);
        myUser.setUserType(person);
        group.setIdMyUserStarosta(myUser);
        group.setNumberOfGroup("345123");
        Subject subject = new Subject();
        subject.setIdSubject(0);
        subject.setNameSubject("23");



        typeOfAttorneyDAO.saveTypeOfAttorney(typeOfAttorney);
        typeInClassDAO.saveTypeInClass(typeInClass);
        personDAO.saveUserType(person);
        subjectDAO.saveSubject(subject);
        System.out.println("Person::"+person);
       // personDAO.deleteUserType(person);
        List<UserType> list = personDAO.list();
        typeOfWorkDAO.saveTypeOfWork(typeOfWork);
        userDAO.saveUser(myUser);
        groupDAO.saveGroup(group);
        person = personDAO.getUserTypeById(1);
        myUser = userDAO.getUserById(1);


        for(UserType p : list){
            System.out.println("Person List::"+p);
        }
        System.out.print(person.getNameUserType());
        //close resources
        //System.out.print(myUser.getUserName());
        context.close();
    }
}