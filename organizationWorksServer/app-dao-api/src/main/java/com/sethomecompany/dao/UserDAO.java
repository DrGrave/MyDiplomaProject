package com.sethomecompany.dao;

import com.sethomecompany.domain.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserDAO {
	List<User> getAllUsers();

	User getUserById(Integer userId);

	Integer getTotalUsersCount();
	
	Integer addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);

	void deleteUserById(Integer id);
}
