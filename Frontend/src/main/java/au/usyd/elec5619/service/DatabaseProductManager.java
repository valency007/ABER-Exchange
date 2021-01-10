package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.ResultSetInternalMethods;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.util.Constants;

@Service(value="productManager")
@Transactional
public class DatabaseProductManager implements ProductManager {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
	}
	
	@Override
	public boolean addProduct(Product product,MultipartFile file) {
		System.out.println("addProduct");
		if (file != null){
			String originalFileName = file.getOriginalFilename(); 
			String suffix = originalFileName.substring(originalFileName.lastIndexOf(".")); 
			String fileName = UUID.randomUUID().toString() + suffix;
			String filePath = Constants.IMG_PATH + fileName;
			System.out.println(filePath);
            File saveFile = new File(filePath);
            try {
                file.transferTo(saveFile);
                product.setImage(fileName);
                this.sessionFactory.getCurrentSession().save(product);
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		return true;
//		this.sessionFactory.getCurrentSession().save(product);
//		return true;
	}
	
	@Override
	public Product getProductById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Product product = (Product) currentSession.get(Product.class, id);
		return product;
	}
	
	@Override
	public void updateProduct(Product product) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(product);
	}
	
	@Override
	public void deleteProduct(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Product product = (Product) currentSession.get(Product.class, id);
		currentSession.delete(product);
	}

	@Override
	public void increasePrice(int percentage) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Product> products = currentSession.createQuery("FROM Product").list();
		
		if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                currentSession.save(product);
            }
        }
	}

	@Override
	public List<Product> getProducts() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Product").list();
	}
	
	@Override
	public List<Product> getProducts(String description){
		String hql="";
		if(description==null||description.equals("")){
//			hql="select from Products products order by products.regdatetime desc";
			System.out.println("error!");
		}else{
			hql="from Product p where p.description ="+ "'"+description+"'";
		}
//		List<Product> products = getHibernateTemplate.find(hql);
		System.out.println(hql);
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> p = (List<Product>) session.createQuery(hql).list();
//		return this.sessionFactory.getCurrentSession().createQuery(hql).list();
		return p;
	}

}
