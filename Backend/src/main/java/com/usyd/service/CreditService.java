package com.usyd.service;

import java.util.List;

import com.usyd.model.Credit;

public interface CreditService {
	
	public void addCredit(Credit credit);
	public void updateCredit(Credit credit);
	public Credit getCredit(int cid);
	public void deleteCredit(int cid);
	public List<Credit> getCredits();

}
