package com.usyd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.model.Credit;

@Repository
public class CreditDAOImpl implements CreditDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addCredit(Credit credit) {
		getCurrentSession().save(credit);
	}

	public void updateCredit(Credit credit) {
		Credit creditToUpdate = getCredit(credit.getCid());
		creditToUpdate.setCemail(credit.getCemail());
		creditToUpdate.setCredit_use(credit.getCredit_use());
		creditToUpdate.setReward(credit.getReward());
		getCurrentSession().update(creditToUpdate);
		
	}

	public Credit getCredit(int cid) {
		Credit credit = (Credit) getCurrentSession().get(Credit.class, cid);
		return credit;
	}

	public void deleteCredit(int cid) {
		Credit credit = getCredit(cid);
		if (credit != null)
			getCurrentSession().delete(credit);
	}

	@SuppressWarnings("unchecked")
	public List<Credit> getCredits() {
		return getCurrentSession().createQuery("from Credit").list();
	}

}
