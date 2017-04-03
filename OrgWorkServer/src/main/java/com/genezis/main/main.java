package com.genezis.main;

import java.util.List;

import com.genezis.dao.GroupDAO;
import com.genezis.dao.UserDAO;
import com.genezis.dao.UserTypeDAO;
import com.genezis.model.Group;
import com.genezis.model.User;
import com.genezis.model.UserType;
import org.springframework.context.support.ClassPathXmlApplicationContext;



class SpringHibernateMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserTypeDAO personDAO = context.getBean(UserTypeDAO.class);
        GroupDAO groupDAO = context.getBean(GroupDAO.class);
        UserDAO userDAO = context.getBean(UserDAO.class);

        Group group = new Group();
        group.setIdGroup(1);
        User user = new User();
        user.setIdUser(13);
        user.setUserName("ff");
        user.setUserSeccondname("ff");
        user.setUserSurname("ff");
        UserType person = new UserType();
        person.setNameUserType("Professor");
        person.setIdUserType(6);
        user.setUserType(person);
        group.setIdUserStarosta(user);
        group.setNumberOfGroup("345123");
        userDAO.saveUser(user);
       groupDAO.saveGroup(group);
      //  personDAO.saveUserType(person);

        System.out.println("Person::"+person);

        List<UserType> list = personDAO.list();

        for(UserType p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close();
    }
}