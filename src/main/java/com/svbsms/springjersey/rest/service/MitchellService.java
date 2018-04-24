package com.svbsms.springjersey.rest.service;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.svbsms.springjersey.rest.model.Vehicle;

public interface MitchellService {
	
	public Vehicle getVehicle(int id);
	
	public List<Vehicle> getVehicles();
	
	public Vehicle createVehicle(Vehicle vehicle);
	
	public void updateVehicleDetails(Vehicle vehicle);
	
	public void deleteVehicle(int id);

}
