package com.sethomecompany.dao;


import com.sethomecompany.domain.Group;
import com.sethomecompany.domain.User;
import com.sethomecompany.domain.UserCredential;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-dao.xml"})
@Transactional()
public class UserDAOImplTest {
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void getAllUsers() throws Exception {
		userDAO.getAllUsers();
	}


	@Test
	public void getUserById() {
		userDAO.getUserById(1);
	}

	@Test
	public void getTotalUsersCount() {
		System.out.println(userDAO.getTotalUsersCount());
	}

	@Test
	public void addUser() throws NoSuchAlgorithmException {
		Group group = new Group(1, "351002", 1);
		User user = new User(1, "fad", "asdaf", "asdf", "adfga@mail.com", group);
		userDAO.addUser(user);
	}

	@Test
	public void updateUser() {
		Group group = new Group(1, "351002", 1);
		User user = new User(1, "fad", "asdafsss", "asdf", "adfga@mail.com", group);
		userDAO.updateUser(user);
	}


	@Test
	public void deleteUserBuId() throws NoSuchAlgorithmException {
		int id = userDAO.getAllUsers().get(1).getId();
		userDAO.deleteUserById(id);
	}


}