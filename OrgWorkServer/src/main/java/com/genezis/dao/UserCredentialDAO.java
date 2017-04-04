package com.genezis.dao;

import com.genezis.model.UserCredentials;

import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserCredentialDAO {
    public void saveUserCredential(UserCredentials userCredential);
    public List<UserCredentials> listUserCredential();
    public UserCredentials getUserCredential(int id);
    public UserCredentials editUserCredential(UserCredentials userCredential);
}
