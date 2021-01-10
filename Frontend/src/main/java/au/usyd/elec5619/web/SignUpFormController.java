package au.usyd.elec5619.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import au.usyd.elec5619.service.SignUp;
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.UserManager;

public class SignUpFormController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private UserManager userManager;
	private User user;

	public ModelAndView onSubmit(Object command) throws ServletException {

		this.user = new User();
		this.user.setEmail(((SignUp) command).getEmail());
		this.user.setPassword(((SignUp) command).getPassword());
		this.user.setFname(((SignUp) command).getFname());
		this.user.setLname(((SignUp) command).getLname());
		logger.info("uM: "+userManager);
		if (userManager.getUserByEmail(this.user.getEmail()) != null) {
			logger.info("hihi");
			
		} else {
			userManager.addNewUser(user);
		}

		logger.info("returning from signup view to " + getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

}