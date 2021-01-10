package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.domain.User;

@Service(value = "userManager")
@Transactional
public class DatabaseUserManager implements UserManager {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addNewUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		for(int i=0; i<this.getUsers().size();i++) {
			if(getUsers().get(i).getEmail().equals(email)) {
				return getUsers().get(i);
			}
		}
		return null;

	}
	
	@Override
	public List<User> getUsers() {
		List<User> users = (List<User>) this.sessionFactory.getCurrentSession().createQuery("FROM User").list();
		return users;
	}

}
