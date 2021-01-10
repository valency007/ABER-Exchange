package com.usyd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.dao.OrderDAO;
import com.usyd.model.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	public void addOrder(Order order) {
		orderDAO.addOrder(order);		
	}

	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	public Order getOrder(int id) {
		return orderDAO.getOrder(id);
	}

	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
	}

	public List<Order> getOrders() {
		return orderDAO.getOrders();
	}

}
