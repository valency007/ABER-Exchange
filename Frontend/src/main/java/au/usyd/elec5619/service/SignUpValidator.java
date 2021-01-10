package au.usyd.elec5619.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import au.usyd.elec5619.service.SignUp;
import au.usyd.elec5619.service.UserManager;

public class SignUpValidator implements Validator {
	private int DEFAULT_MIN_PERCENTAGE = 0;
	private int DEFAULT_MAX_PERCENTAGE = 50;
	private int minPercentage = DEFAULT_MIN_PERCENTAGE;
	private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	private UserManager userManager;
	public boolean supports(Class clazz) {
		return SignUp.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		SignUp su = (SignUp) obj;
		if (su.getEmail() == null || su.getEmail().equals("")) {
			errors.rejectValue("email", "error.not-specifiedEmail", new Object[] { new String("email") },
					"Value required.");
			logger.info("Validating with " + su + ": " + su.getEmail());
		} 
		if (su.getFname() == null || su.getFname().equals("")) {
			errors.rejectValue("fname", "error.not-specifiedFname", new Object[] { new String("fname") },
					"Value required.");
			logger.info("Validating with " + su + ": " + su.getFname());
		} 
		if (su.getLname() == null || su.getLname().equals("")) {
			errors.rejectValue("lname", "error.not-specifiedLname", new Object[] { new String("lname") },
					"Value required.");
			logger.info("Validating with " + su + ": " + su.getLname());
		} 
		if (su.getPassword() == null || su.getPassword().equals("")) {
			errors.rejectValue("password", "error.not-specifiedPass", new Object[] { new String("password") },
					"Value required.");
			logger.info("Validating with " + su + ": " + su.getPassword());
		}
		if(su.getEmail() != null && !su.getEmail().equals("")) {
//			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("../src/main/webapp/WEB-INF/spring/appServlet/persistence-context.xml");
//	        UserManager udi=context.getBean(UserManager.class);
	        
//			this.userManager.getUsers();
			logger.info("email is: "+userManager);
//			if (this.userManager.getUserByEmail(su.getEmail()) != null) {
//				logger.info("hihi");
//				
//			}
		}
	}
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

}