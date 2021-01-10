package com.usyd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.dao.UserDAO;
import com.usyd.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public void addUser(User user) {
		userDAO.addUser(user);		
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public User getUser(int uid) {
		return userDAO.getUser(uid);
	}

	public void deleteUser(int uid) {
		userDAO.deleteUser(uid);
	}

	public List<User> getUsers() {
		return userDAO.getUsers();
	}

}
