package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_information")
public class Purchase implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "category")
	private String category;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@Column(name = "credit")
	private int credit;

	@Column(name = "owner_uid")
	private int owner_uid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getOwner_uid() {
		return owner_uid;
	}

	public void setOwner_uid(int owner_uid) {
		this.owner_uid = owner_uid;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("title: " + title + ";");
		buffer.append("category: " + category + ";");
		buffer.append("image: " + image + ";");
		buffer.append("description: " + description + ";");
		buffer.append("credit: " + credit + ";");
		buffer.append("owner_uid: " + owner_uid + ";");

		return buffer.toString();
	}

}
