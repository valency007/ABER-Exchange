package com.usyd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credit_redemption")
public class Credit {
	
	@Id
	@GeneratedValue
	private Integer cid;	
	private Integer credit_use;
	private String cemail;
	private String reward;
	
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	
	
	public Integer getCredit_use() {
		return credit_use;
	}
	public void setCredit_use(Integer credit_use) {
		this.credit_use = credit_use;
	}
	
	

}
