package com.usyd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.dao.RiderDAO;
import com.usyd.model.Rider;

@Service
@Transactional
public class RiderServiceImpl implements RiderService {
	
	@Autowired
	private RiderDAO riderDAO;

	public void addRider(Rider rider) {
		riderDAO.addRider(rider);		
	}

	public void updateRider(Rider rider) {
		riderDAO.updateRider(rider);
	}

	public Rider getRider(int id) {
		return riderDAO.getRider(id);
	}

	public void deleteRider(int id) {
		riderDAO.deleteRider(id);
	}

	public List<Rider> getRiders() {
		return riderDAO.getRiders();
	}

}
