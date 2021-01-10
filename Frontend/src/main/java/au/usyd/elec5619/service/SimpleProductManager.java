package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import au.usyd.elec5619.domain.Product;

public class SimpleProductManager implements ProductManager {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void increasePrice(int percentage) {
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
			}
		}
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		this.products.add(product);
		
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		for(int i=0; i<this.products.size();i++) {
			if(products.get(i).getId()==id) {
				return products.get(i);
			}
		}
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		for(int i=0; i<this.products.size();i++) {
			if(products.get(i).getId()==product.getId()) {
				products.get(i).setDescription(product.getDescription());
				products.get(i).setPrice(product.getPrice());
				
			}
		}
		
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		System.out.println("id_"+id);
		for(int i=0; i<this.products.size();i++) {
			if(products.get(i).getId()==id) {
				products.remove(i);
			}
		}
	}
	
	@Override
	public boolean addProduct(Product product,MultipartFile file) {
		return true;
	}
	
	@Override
	public List<Product> getProducts(String description){
		return products;
	}

}
