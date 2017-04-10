package com.genezis.service;

import com.genezis.dao.UserTypeDAO;
import com.genezis.model.UserType;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vadim on 03.04.17.
 */
@Service("userTypeService")
@Transactional
public class UserTypeServiceImpl implements UserTypeService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private UserTypeDAO userTypeDAO = context.getBean(UserTypeDAO.class);
    @Override
    public void saveUserType(UserType userType) {
        userTypeDAO.saveUserType(userType);
    }

    @Override
    public UserType getUserTypeById(int id) {
        return userTypeDAO.getUserTypeById(id);
    }

    @Override
    public UserType editUserType(UserType userType) {
        return userTypeDAO.editUserType(userType);
    }

    @Override
    public void deleteUserType(UserType userType) {
        userTypeDAO.deleteUserType(userType);
    }

    @Override
    public UserType ifExists(UserType userType) {
       return userTypeDAO.ifExistsUserType(userType);
    }
}
