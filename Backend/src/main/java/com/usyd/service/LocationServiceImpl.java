package com.usyd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.dao.LocationDAO;
import com.usyd.model.Location;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationDAO riderDAO;

	public List<Location> getLocations() {
		return riderDAO.getLocations();
	}

}
