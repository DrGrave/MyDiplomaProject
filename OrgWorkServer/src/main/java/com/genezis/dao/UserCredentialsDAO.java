package com.genezis.dao;

import com.genezis.model.UserCredentials;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserCredentialsDAO {
    void saveUserCredential(UserCredentials userCredential);
    List<UserCredentials> listUserCredential();
    UserCredentials getUserCredential(int id);
    UserCredentials editUserCredential(UserCredentials userCredential);
    void deleteUserCredentials(UserCredentials userCredentials);
}
