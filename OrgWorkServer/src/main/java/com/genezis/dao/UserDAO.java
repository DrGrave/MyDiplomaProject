package com.genezis.dao;

import com.genezis.model.myUser;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserDAO {
    void saveUser(myUser myUser);
    List<myUser> list();
    myUser getUserById(int id);
    void deleteUser(myUser myUser);
    myUser editUser(myUser myUser);
}
