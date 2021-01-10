package com.usyd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Product getProduct(int uid) {
		Product product = (Product) getCurrentSession().get(Product.class, uid);
		return product;
	}

	public void deleteProduct(int uid) {
		Product product = getProduct(uid);
		if (product != null)
			getCurrentSession().delete(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		return getCurrentSession().createQuery("from Product").list();
	}

}
