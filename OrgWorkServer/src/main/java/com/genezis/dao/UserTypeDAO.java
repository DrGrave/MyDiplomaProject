package com.genezis.dao;

import com.genezis.model.UserType;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserTypeDAO {
    void saveUserType(UserType userType);
    List<UserType> list();
    UserType getUserTypeById(int id);
    void deleteUserType(UserType userType);
    UserType editUserType(UserType userType);
}
