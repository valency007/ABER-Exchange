package au.usyd.elec5619.web;

import java.util.Map;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.service.SimpleProductManager;

public class InventoryControllerTest extends TestCase {

    public void testHandleRequestView() throws Exception{
        ProdController controller = new ProdController();
        controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}