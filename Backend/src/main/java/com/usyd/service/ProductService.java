package com.usyd.service;

import java.util.List;

import com.usyd.model.Product;

public interface ProductService {
	
	public Product getProduct(int uid);
	public void deleteProduct(int uid);
	public List<Product> getProducts();

}
