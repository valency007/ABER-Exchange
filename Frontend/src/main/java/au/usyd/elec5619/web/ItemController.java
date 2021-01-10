package au.usyd.elec5619.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;

@Controller
public class ItemController{
	
	protected final Log logger = LogFactory.getLog(getClass());

    private ProductManager productManager;
    
    public String showItem(Product product, Model model, HttpServletRequest httpServletRequest){
    	
    	String desp = product.getDescription();
    	System.out.println(desp);
    	return "";
    }
    
    
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }
}
