package com.genezis.dao;

import com.genezis.model.User;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserDAO {
    public void saveUser(User user);
    public List<User> list();
    public User getUserById(int id);
}
