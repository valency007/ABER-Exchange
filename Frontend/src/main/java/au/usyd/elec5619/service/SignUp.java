package au.usyd.elec5619.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import au.usyd.elec5619.domain.User;

public class SignUp {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private String email;
	private String password;
	private String fname;
	private String lname;

//	private Object sessionFactory;

	public void setEmail(String email) {
		this.email = email;
		logger.info("email set to " + email);
	}

	public String getEmail() {
		return this.email;
	}

	public void setPassword(String password) {
		this.password = password;
		logger.info("password set to " + password);
	}

	public String getPassword() {
		return this.password;
	}

	public void setFname(String fname) {
		this.fname = fname;
		logger.info("fname set to " + fname);
	}

	public String getFname() {
		return this.fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
		logger.info("email set to " + lname);
	}

	public String getLname() {
		return this.lname;
	}
	
//	public List<User> getUsers() {
//		List<User> users = (List<User>) this.sessionFactory.getCurrentSession().createQuery("FROM User").list();
//		return users;
//	}
//	

}