package com.genezis.dao;

import com.genezis.model.MyUserCredentials;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserCredentialsDAO {
    void saveUserCredential(MyUserCredentials userCredential) throws NoSuchAlgorithmException;
    List<MyUserCredentials> listUserCredential();
    MyUserCredentials getUserCredential(int id);
    MyUserCredentials editUserCredential(MyUserCredentials userCredential);
    void deleteUserCredentials(MyUserCredentials myUserCredentials);
    MyUserCredentials getUserCredentialsByLP(String login, String password) throws NoSuchAlgorithmException;
    MyUserCredentials ifExistsMyUserCred(MyUserCredentials myUserCredentials);
}
