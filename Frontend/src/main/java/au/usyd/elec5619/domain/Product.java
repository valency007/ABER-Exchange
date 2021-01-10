package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
public class Product implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	@Column(name="Description")
    private String description;
	
	@Column(name="Price")
    private Double price;
	
	@Column(name="Image")
	private String image;
	
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }
}
