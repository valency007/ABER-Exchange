package au.usyd.elec5619.web;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);
//		return new ModelAndView("hello", "now", now);
		return new ModelAndView("WEB-INF/views/hello.jsp", "now", now);
	}
}