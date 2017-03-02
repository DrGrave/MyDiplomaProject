package com.sethomecompany.dao;

import com.sethomecompany.domain.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class UserDAOImpl implements UserDAO{

	
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER = LogManager.getLogger();

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<User> getAllUsers() {
		LOGGER.debug("getAllUsers()");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User order by id");
		List<User> list = query.list();
		session.getTransaction().commit();
		return list;
	}



	@Override
	public User getUserById(Integer userId) {
		LOGGER.debug("getUserById({})", userId);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User u where u.id=:id");
		query.setParameter("id", userId);
		List<User> list = query.list();
		session.getTransaction().commit();
		return ifExists(list);
	}
	
//	@Override
//	public Integer getCountUsers(String login) {
//		return null;
//	}
	
	@Override
	public Integer getTotalUsersCount() {
		LOGGER.debug("getTotalUsersCount()");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");// group by id");
		List<User> list = query.list();
		session.getTransaction().commit();
		return list.size();
	}
	
	@Override
	public Integer addUser(User user){
//		LOGGER.debug("addUser(user): login = {}",);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return user.getId();
	}
	
	@Override
	public void updateUser(User user) {
//		LOGGER.debug("updateUser(user): {}", user.getUserCredential().getLogin());
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	
	@Override
	public void deleteUser(User user) {
		LOGGER.debug("deleteUser(user): {}", user.getId());
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(user);
		session.flush();
		session.getTransaction().commit();
	}

	@Override
	public void deleteUserById(Integer id) {
		LOGGER.debug("deleteUserById(): {}", id);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User u where u.id=:id");
		query.setParameter("id", id);
		List<User> list = query.list();
		session.delete(list.get(0));
		session.flush();
		session.getTransaction().commit();
	}

	private User ifExists(List<User> userList){
		if(userList.size() > 0){
			return userList.get(0);
		}else {
			return null;
		}
	}



}
