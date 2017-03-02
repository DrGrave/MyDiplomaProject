package com.sethomecompany.dao;

import com.sethomecompany.domain.UserCredential;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertNull;

/**
 * Created by Vadim on 12.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-dao.xml"})
@Transactional()
public class UserCredentialsDAOImplTest {
    @Autowired
    private UserCredentialDAO userCredentialDAO;

    @Test
    public void addCredential() throws NoSuchAlgorithmException {
       UserCredential userCredential = new UserCredential(1, "sdfsd", "asdas", 2, 1);
        userCredentialDAO.addCredential(userCredential);
        System.out.println();
    }

    @Test
    public void deleteUserCredential() throws NoSuchAlgorithmException {
        UserCredential userCredential = new UserCredential();
        userCredential = userCredentialDAO.getUserIfExist("sdfsd", "asdas");
        userCredentialDAO.deleteUserCredential(userCredential);

    }

    @Test
    public void getUserByLogin() {
        UserCredential userCredential = new UserCredential();
        userCredential = userCredentialDAO.getUserByLogin("sdfsd");
    }

    @Test
    public void getUserIfExist() throws NoSuchAlgorithmException {
        UserCredential userCredential = new UserCredential();
        userCredential = userCredentialDAO.getUserIfExist("sdfsd", "asdas");
    }

}
