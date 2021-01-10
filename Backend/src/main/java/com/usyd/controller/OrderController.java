package com.usyd.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.usyd.model.Order;
import com.usyd.service.OrderService;
import com.usyd.model.Credit;
import com.usyd.service.CreditService;
import com.usyd.model.User;
import com.usyd.service.UserService;
import com.usyd.model.Rider;
import com.usyd.service.RiderService;
import com.usyd.model.Location;
import com.usyd.service.LocationService;
import com.usyd.model.Product;
import com.usyd.service.ProductService;

@Controller
@RequestMapping(value="/admin")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CreditService creditService;
	@Autowired
	private UserService userService;
	@Autowired
	private RiderService riderService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addOrderPage() {
		ModelAndView modelAndView = new ModelAndView("add-order-form");
		modelAndView.addObject("order", new Order());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingOrder(@ModelAttribute Order order) {
		
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		orderService.addOrder(order);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		
		
		String message = "Order was successfully added";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfOrders() {
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);

		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editOrderPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-order-form");
		Order order = orderService.getOrder(id);
		modelAndView.addObject("order",order);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingOrder(@ModelAttribute Order order, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		orderService.updateOrder(order);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		
		String message = "Order was successfully edited";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteOrder(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		orderService.deleteOrder(id);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		String message = "Order was successfully deleted";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/credit/delete/{cid}", method=RequestMethod.GET)
	public ModelAndView deleteCredit(@PathVariable Integer cid) {
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		creditService.deleteCredit(cid);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		String message = "Credit Entry was successfully deleted";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/credit/add", method=RequestMethod.GET)
	public ModelAndView addCreditPage() {
		ModelAndView modelAndView = new ModelAndView("add-credit-form");
		modelAndView.addObject("credit", new Credit());
		return modelAndView;
	}
	
	@RequestMapping(value="/credit/add", method=RequestMethod.POST)
	public ModelAndView addingCredit(@ModelAttribute Credit credit) {
		
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		creditService.addCredit(credit);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		
		String message = "Credit Entry was successfully added";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/credit/edit/{cid}", method=RequestMethod.GET)
	public ModelAndView editCreditPage(@PathVariable Integer cid) {
		ModelAndView modelAndView = new ModelAndView("edit-credit-form");
		Credit credit = creditService.getCredit(cid);
		modelAndView.addObject("credit",credit);
		return modelAndView;
	}
	
	@RequestMapping(value="/credit/edit/{cid}", method=RequestMethod.POST)
	public ModelAndView edditingCredit(@ModelAttribute Credit credit, @PathVariable Integer cid) {
		
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		creditService.updateCredit(credit);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		
		String message = "Credit Entry was successfully edited";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	///////////////////////////////////////////////////
	
	@RequestMapping(value="/user/delete/{uid}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer uid) {
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		userService.deleteUser(uid);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		String message = "User was successfully deleted";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("add-user-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user) {
		
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		userService.addUser(user);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		
		String message = "New User was successfully added";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/user/edit/{uid}", method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer uid) {
		ModelAndView modelAndView = new ModelAndView("edit-user-form");
		User user = userService.getUser(uid);
		modelAndView.addObject("user",user);
		return modelAndView;
	}
	
	@RequestMapping(value="/user/edit/{uid}", method=RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer uid) {
		
		ModelAndView modelAndView = new ModelAndView("list-of-orders");
		userService.updateUser(user);
		List<Order> orders = orderService.getOrders();
		List<Credit> credits = creditService.getCredits();
		List<User> users = userService.getUsers();
		List<Rider> riders = riderService.getRiders();
		List<Location> locations = locationService.getLocations();
		modelAndView.addObject("orders", orders);
		modelAndView.addObject("credits", credits);
		modelAndView.addObject("users", users);
		modelAndView.addObject("riders", riders);
		modelAndView.addObject("locations", locations);
		
		String message = "User Entry was successfully edited";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
///////////////////////////////////////////////////
	
@RequestMapping(value="/rider/delete/{id}", method=RequestMethod.GET)
public ModelAndView deleteRider(@PathVariable Integer id) {
ModelAndView modelAndView = new ModelAndView("list-of-orders");
riderService.deleteRider(id);
List<Order> orders = orderService.getOrders();
List<Credit> credits = creditService.getCredits();
List<User> users = userService.getUsers();
List<Rider> riders = riderService.getRiders();
List<Location> locations = locationService.getLocations();
modelAndView.addObject("orders", orders);
modelAndView.addObject("credits", credits);
modelAndView.addObject("users", users);
modelAndView.addObject("riders", riders);
modelAndView.addObject("locations", locations);
String message = "Rider was successfully deleted";
modelAndView.addObject("message", message);
return modelAndView;
}

@RequestMapping(value="/rider/add", method=RequestMethod.GET)
public ModelAndView addRiderPage() {
ModelAndView modelAndView = new ModelAndView("add-rider-form");
modelAndView.addObject("rider", new Rider());
return modelAndView;
}

@RequestMapping(value="/rider/add", method=RequestMethod.POST)
public ModelAndView addingRider(@ModelAttribute Rider rider) {

ModelAndView modelAndView = new ModelAndView("list-of-orders");
riderService.addRider(rider);
List<Order> orders = orderService.getOrders();
List<Credit> credits = creditService.getCredits();
List<User> users = userService.getUsers();
List<Rider> riders = riderService.getRiders();
List<Location> locations = locationService.getLocations();
modelAndView.addObject("orders", orders);
modelAndView.addObject("credits", credits);
modelAndView.addObject("users", users);
modelAndView.addObject("riders", riders);
modelAndView.addObject("locations", locations);

String message = "New Rider was successfully added";
modelAndView.addObject("message", message);

return modelAndView;
}

@RequestMapping(value="/rider/edit/{id}", method=RequestMethod.GET)
public ModelAndView editRiderPage(@PathVariable Integer id) {
ModelAndView modelAndView = new ModelAndView("edit-rider-form");
Rider rider = riderService.getRider(id);
modelAndView.addObject("rider",rider);
return modelAndView;
}

@RequestMapping(value="/rider/edit/{id}", method=RequestMethod.POST)
public ModelAndView edditingRider(@ModelAttribute Rider rider, @PathVariable Integer id) {

ModelAndView modelAndView = new ModelAndView("list-of-orders");
riderService.updateRider(rider);
List<Order> orders = orderService.getOrders();
List<Credit> credits = creditService.getCredits();
List<User> users = userService.getUsers();
List<Rider> riders = riderService.getRiders();
List<Location> locations = locationService.getLocations();
modelAndView.addObject("orders", orders);
modelAndView.addObject("credits", credits);
modelAndView.addObject("users", users);
modelAndView.addObject("riders", riders);
modelAndView.addObject("locations", locations);

String message = "Rider Information was successfully edited";
modelAndView.addObject("message", message);

return modelAndView;
}

///////////////////////////////////////


@RequestMapping(value="/products")
public ModelAndView listOfProducts() {
	ModelAndView modelAndView = new ModelAndView("list-of-products");
	
	List<Product> products = productService.getProducts();
	modelAndView.addObject("products", products);

	
	return modelAndView;
}

@RequestMapping(value="/products/delete/{id}", method=RequestMethod.GET)
public ModelAndView deleteProduct(@PathVariable Integer id) {
ModelAndView modelAndView = new ModelAndView("list-of-products");

productService.deleteProduct(id);
List<Product> products = productService.getProducts();
modelAndView.addObject("products", products);

String message = "Product was successfully deleted";
modelAndView.addObject("message", message);
return modelAndView;
}






}

