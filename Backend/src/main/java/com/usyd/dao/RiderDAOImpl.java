package com.usyd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.model.Rider;

@Repository
public class RiderDAOImpl implements RiderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addRider(Rider rider) {
		getCurrentSession().save(rider);
	}

	public void updateRider(Rider rider) {
		Rider riderToUpdate = getRider(rider.getId());
		riderToUpdate.setEmail(rider.getEmail());
		riderToUpdate.setPassword(rider.getPassword());
		getCurrentSession().update(riderToUpdate);
		
	}

	public Rider getRider(int id) {
		Rider rider = (Rider) getCurrentSession().get(Rider.class, id);
		return rider;
	}

	public void deleteRider(int id) {
		Rider rider = getRider(id);
		if (rider != null)
			getCurrentSession().delete(rider);
	}

	@SuppressWarnings("unchecked")
	public List<Rider> getRiders() {
		return getCurrentSession().createQuery("from Rider").list();
	}

}
