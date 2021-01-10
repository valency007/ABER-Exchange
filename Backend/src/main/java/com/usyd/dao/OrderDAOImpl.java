package com.usyd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addOrder(Order order) {
		getCurrentSession().save(order);
	}

	public void updateOrder(Order order) {
		Order orderToUpdate = getOrder(order.getId());
		orderToUpdate.setName(order.getName());
		orderToUpdate.setEmail(order.getEmail());
		orderToUpdate.setCnumber(order.getCnumber());
		orderToUpdate.setS_address(order.getS_address());
		orderToUpdate.setD_address(order.getD_address());
		orderToUpdate.setNotes(order.getNotes());
		orderToUpdate.setIsDonation(order.getIsDonation());
		orderToUpdate.setStatus(order.getStatus());
		orderToUpdate.setRider(order.getRider());
		getCurrentSession().update(orderToUpdate);
		
	}

	public Order getOrder(int id) {
		Order order = (Order) getCurrentSession().get(Order.class, id);
		return order;
	}

	public void deleteOrder(int id) {
		Order order = getOrder(id);
		if (order != null)
			getCurrentSession().delete(order);
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		return getCurrentSession().createQuery("from Order").list();
	}

}
