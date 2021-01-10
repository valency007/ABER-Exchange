package com.usyd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usyd.model.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

//	public void addLocation(Location location) {
//		getCurrentSession().save(location);
//	}
//
//	public void updateLocation(Location location) {
//		Location locationToUpdate = getLocation(location.getEmail());
//		locationToUpdate.setLat(location.getLat());
//		locationToUpdate.setLon(location.getLon());
//		getCurrentSession().update(locationToUpdate);
//		
//	}
//
//	public Location getLocation(int id) {
//		Location location = (Location) getCurrentSession().get(Location.class, id);
//		return location;
//	}


	@SuppressWarnings("unchecked")
	public List<Location> getLocations() {
		return getCurrentSession().createQuery("from Location").list();
	}

}
