package com.genezis.dao;

import com.genezis.model.MyUser;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserDAO {
    void saveUser(MyUser MyUser);
    List<MyUser> list();
    MyUser getUserById(int id);
    void deleteUser(MyUser MyUser);
    MyUser editUser(MyUser MyUser);
}
