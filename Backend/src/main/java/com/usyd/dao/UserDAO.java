package com.usyd.dao;

import java.util.List;

import com.usyd.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public void updateUser(User user);
	public User getUser(int uid);
	public void deleteUser(int uid);
	public List<User> getUsers();

}
