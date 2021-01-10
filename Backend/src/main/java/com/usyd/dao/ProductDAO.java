package com.usyd.dao;

import java.util.List;

import com.usyd.model.Product;

public interface ProductDAO {
	public Product getProduct(int uid);
	public void deleteProduct(int uid);
	public List<Product> getProducts();

}
