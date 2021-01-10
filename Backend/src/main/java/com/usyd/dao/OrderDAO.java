package com.usyd.dao;

import java.util.List;

import com.usyd.model.Order;

public interface OrderDAO {
	
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public Order getOrder(int id);
	public void deleteOrder(int id);
	public List<Order> getOrders();

}
