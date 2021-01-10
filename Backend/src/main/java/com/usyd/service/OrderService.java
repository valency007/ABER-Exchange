package com.usyd.service;

import java.util.List;

import com.usyd.model.Order;

public interface OrderService {
	
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public Order getOrder(int id);
	public void deleteOrder(int id);
	public List<Order> getOrders();

}
