package com.usyd.dao;

import java.util.List;

import com.usyd.model.Rider;

public interface RiderDAO {
	
	public void addRider(Rider rider);
	public void updateRider(Rider rider);
	public Rider getRider(int id);
	public void deleteRider(int id);
	public List<Rider> getRiders();

}
