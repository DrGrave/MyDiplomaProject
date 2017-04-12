package com.genezis.service;

import com.genezis.dao.UserCredentialsDAO;
import com.genezis.model.MyUserCredentials;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * Created by vadim on 03.04.17.
 */
@Service("userCredentialsService")
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private UserCredentialsDAO userCredentialsDAO = context.getBean(UserCredentialsDAO.class);

    @Override
    public void saveMyUserCredentials(MyUserCredentials myUserCredentials) throws NoSuchAlgorithmException {
        userCredentialsDAO.saveUserCredential(myUserCredentials);
    }

    @Override
    public MyUserCredentials getMyUserCredentialsById(int id) {
        return userCredentialsDAO.getUserCredential(id);
    }

    @Override
    public MyUserCredentials editMyUserCredentials(MyUserCredentials myUserCredentials) {
        return userCredentialsDAO.editUserCredential(myUserCredentials);
    }

    @Override
    public void deleteMyUserCredentials(MyUserCredentials myUserCredentials) {
        userCredentialsDAO.deleteUserCredentials(myUserCredentials);
    }

    @Override
    public MyUserCredentials ifExists(MyUserCredentials myUserCredentials) {
        userCredentialsDAO.ifExistsMyUserCred(myUserCredentials);
        return null;
    }

    @Override
    public MyUserCredentials getUserCredentialsByLP(String login, String password) throws NoSuchAlgorithmException {
        return  userCredentialsDAO.getUserCredentialsByLP(login, password);
    }
}
