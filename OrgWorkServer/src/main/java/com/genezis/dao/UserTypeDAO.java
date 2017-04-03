package com.genezis.dao;

import com.genezis.model.UserType;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserTypeDAO {
    public void saveUserType(UserType userType);
    public List<UserType> list();
    public UserType getUserTypeById(int id);
}
