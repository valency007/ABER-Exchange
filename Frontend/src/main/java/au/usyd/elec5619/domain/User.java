package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_information")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="uid")
	private long uid;
	
	@Column(name="fname", nullable=false)
    private String fname;
	
	@Column(name="lname", nullable=false)
    private String lname;
	
	@Column(name="email", nullable=false, unique=true)
    private String email;
	
	@Column(name="password", nullable=false)
    private String password;
	
	@Column(name="credit", nullable=false)
    private int credit;
	
	@Column(name="uploaded_item_count", nullable=false)
    private int uploaded_item_count;
    
    public long getId() {
		return uid;
	}

	public void setId(long uid) {
		this.uid = uid;
	}

	public String getFname() {
        return fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getLname() {
        return lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public int getUploadCount() {
        return uploaded_item_count;
    }
    
    public void setUploadCount(int uploaded_item_count) {
        this.uploaded_item_count = uploaded_item_count;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("fname: " + fname + ";");
        buffer.append("lname: " + lname+ ";");
        buffer.append("email: " + email+ ";");
        buffer.append("credit: " + credit+ ";");
        buffer.append("uploaded_item_count: " + uploaded_item_count+ ";");
        
        return buffer.toString();
    }
}
