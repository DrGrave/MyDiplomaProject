package com.genezis.service;

import com.genezis.dao.UserDAO;
import com.genezis.model.MyUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private UserDAO userDAO = context.getBean(UserDAO.class);
    @Override
    public void saveMyUser(MyUser myUser) {
    userDAO.saveUser(myUser);
    }

    @Override
    public MyUser getMyUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public MyUser editMyUser(MyUser myUser) {
        return userDAO.editUser(myUser);
    }

    @Override
    public void deleteMyUser(MyUser myUser) {
        userDAO.deleteUser(myUser);
    }

    @Override
    public MyUser ifExists(MyUser myUser) {
        return userDAO.ifExistsMyUser(myUser);
    }
}
