package com.genezis.main;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.genezis.dao.*;
import com.genezis.model.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;



class SpringHibernateMain {

    public static void main(String[] args) throws NoSuchAlgorithmException {

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

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setIdGroup(1);
        MyUser MyUser = new MyUser();
        MyUser.setIdUser(2);
        MyUser.setUserName("ff");
        MyUser.setUserSeccondname("ff");
        MyUser.setUserSurname("ff");
        UserType person = new UserType();
        person.setNameUserType("Professor1");
        person.setIdUserType(1);
        MyUser.setUserType(person);
        studentGroup.setIdMyUserStarosta(MyUser);
        studentGroup.setNumberOfGroup("345123");
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
        userDAO.saveUser(MyUser);
        groupDAO.saveGroup(studentGroup);
        person = personDAO.getUserTypeById(1);
        MyUser = userDAO.getUserById(1);
        MyUserCredentials myUserCredentials = new MyUserCredentials();
        myUserCredentials.setUserPassword("pass1");
        myUserCredentials.setUserLogin("Log2");
        myUserCredentials.setMyUser(MyUser);
        userCredentialsDAO.saveUserCredential(myUserCredentials);
        MyUserCredentials myUserCredentials1 = new MyUserCredentials();
        myUserCredentials1 = userCredentialsDAO.getUserCredentialsByLP("Log2","pass1");
        System.out.print(myUserCredentials1.getUserLogin());
        for(UserType p : list){
            System.out.println("Person List::"+p);
        }
        System.out.print(person.getNameUserType());
        //close resources
        //System.out.print(MyUser.getUserName());
        context.close();
    }
}