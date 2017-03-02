package com.sethomecompany.dao;

import com.sethomecompany.domain.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Vadim on 11.12.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-dao.xml"})
@Transactional()
public class GroupDAOImplTest {
    @Autowired
    GroupDAO groupDAO;

    @Test
    public void addGroup() throws NoSuchAlgorithmException {
        Group group = new Group(1, "351002", 1);
        groupDAO.addGroup(group);
        System.out.println(groupDAO.addGroup(group));
    }

    @Test
    public void getGroup() throws NoSuchAlgorithmException {
        groupDAO.getGroup(1);
    }


}
