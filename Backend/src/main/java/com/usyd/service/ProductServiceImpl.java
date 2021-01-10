package com.usyd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.dao.ProductDAO;
import com.usyd.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	public Product getProduct(int uid) {
		return productDAO.getProduct(uid);
	}

	public void deleteProduct(int uid) {
		productDAO.deleteProduct(uid);
	}

	public List<Product> getProducts() {
		return productDAO.getProducts();
	}
}
