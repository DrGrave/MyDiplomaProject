package com.genezis.service;

import com.genezis.model.MyUserCredentials;

import java.security.NoSuchAlgorithmException;

/**
 * Created by vadim on 03.04.17.
 */
public interface UserCredentialsService {
    void saveMyUserCredentials(MyUserCredentials myUserCredentials) throws NoSuchAlgorithmException;
    MyUserCredentials getMyUserCredentialsById(int id);
    MyUserCredentials editMyUserCredentials(MyUserCredentials myUserCredentials);
    void deleteMyUserCredentials(MyUserCredentials myUserCredentials);
    MyUserCredentials ifExists(MyUserCredentials myUserCredentials);
    MyUserCredentials getUserCredentialsByLP(String login, String password) throws NoSuchAlgorithmException;
}
