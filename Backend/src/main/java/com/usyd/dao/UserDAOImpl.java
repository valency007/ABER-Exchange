package com.usyd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(User user) {
		getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		User userToUpdate = getUser(user.getUid());
		userToUpdate.setFname(user.getFname());
		userToUpdate.setLname(user.getLname());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setContact_number(user.getContact_number());
		userToUpdate.setCredit(user.getCredit());
		getCurrentSession().update(userToUpdate);
		
	}

	public User getUser(int uid) {
		User user = (User) getCurrentSession().get(User.class, uid);
		return user;
	}

	public void deleteUser(int uid) {
		User user = getUser(uid);
		if (user != null)
			getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

}
