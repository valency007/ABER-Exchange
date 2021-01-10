package com.usyd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.dao.CreditDAO;
import com.usyd.model.Credit;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {
	
	@Autowired
	private CreditDAO creditDAO;

	public void addCredit(Credit credit) {
		creditDAO.addCredit(credit);		
	}

	public void updateCredit(Credit credit) {
		creditDAO.updateCredit(credit);
	}

	public Credit getCredit(int cid) {
		return creditDAO.getCredit(cid);
	}

	public void deleteCredit(int cid) {
		creditDAO.deleteCredit(cid);
	}

	public List<Credit> getCredits() {
		return creditDAO.getCredits();
	}

}
