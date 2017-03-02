package com.sethomecompany.dao;


import com.sethomecompany.domain.UserCredential;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Vadim on 12.11.2016.
 */
public interface UserCredentialDAO {
    Integer addCredential(UserCredential userCredential) throws NoSuchAlgorithmException;
    void deleteUserCredential(UserCredential userCredential);
    UserCredential getUserIfExist(String login, String password) throws NoSuchAlgorithmException;
    UserCredential getUserByLogin(String login);
}
