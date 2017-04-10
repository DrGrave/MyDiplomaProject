package com.genezis.service;

import com.genezis.model.MyUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vadim on 03.04.17.
 */
public class UserServiceImpl implements UserService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Override
    public void saveMyUser(MyUser myUser) {

    }

    @Override
    public MyUser getMyUserById(int id) {
        return null;
    }

    @Override
    public MyUser editMyUser(MyUser myUser) {
        return null;
    }

    @Override
    public void deleteMyUser(MyUser myUser) {

    }

    @Override
    public MyUser ifExists(MyUser myUser) {
        return null;
    }
}
