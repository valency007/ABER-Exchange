package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.domain.Product;

public interface ProductManager extends Serializable{

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();
    
    public List<Product> getProducts(String description);
    
    public void addProduct(Product product);
    
    public boolean addProduct(Product product, MultipartFile file);
    
    public Product getProductById(long id);
    
    public void updateProduct(Product product);
    
    public void deleteProduct(long id);

       
}