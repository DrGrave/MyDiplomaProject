package com.genezis.service;

import com.genezis.model.UserType;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserTypeService {
    void saveUserType(UserType userType);
    UserType getUserTypeById(int id);
    UserType editUserType(UserType userType);
    void deleteUserType(UserType userType);
    boolean ifExists(UserType userType);
}
