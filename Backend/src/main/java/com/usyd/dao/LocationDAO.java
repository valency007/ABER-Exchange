package com.usyd.dao;

import java.util.List;

import com.usyd.model.Location;

public interface LocationDAO {
	
//	public void addLocation(Location location);
//	public void updateLocation(Location location);
//	public Location getLocation(String email);
//	public void deleteLocation(String email);
	public List<Location> getLocations();

}
