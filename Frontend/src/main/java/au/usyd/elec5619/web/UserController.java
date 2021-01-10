package au.usyd.elec5619.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.UserManager;

@Controller
@RequestMapping(value="/user/**")
public class UserController {
	
	@Resource(name="userManager")
	private UserManager userManager;

	@RequestMapping(value="/signup")
	public String addProduct(Model uiModel) {
		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		
		User user = new User();
		user.setFname(httpServletRequest.getParameter("fname"));
		user.setLname(httpServletRequest.getParameter("lname"));
		user.setEmail(httpServletRequest.getParameter("email"));
		user.setPassword(httpServletRequest.getParameter("password"));
		user.setCredit(0);
		user.setUploadCount(0);
		this.userManager.addNewUser(user);
		
		return "redirect:/hello.htm";
	}

}
