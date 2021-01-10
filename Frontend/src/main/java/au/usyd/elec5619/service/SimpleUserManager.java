package au.usyd.elec5619.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import au.usyd.elec5619.domain.User;

public class SimpleUserManager implements UserManager {
	private List<User> users;

	@Override
	public void addNewUser(User user) {
		this.users.add(user);
		
	}
	
	@Override 
	public User getUserByEmail(String email){
		for(int i=0; i<this.users.size();i++) {
			if(users.get(i).getEmail().equals(email)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	@Override
	public List<User> getUsers() {
		return users;
	}

}
