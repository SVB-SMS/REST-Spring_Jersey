package com.svbsms.springjersey.dao;

import java.util.List;

import com.svbsms.springjersey.rest.model.Vehicle;

public interface VehicleDao {

	public List<Vehicle> getVehicles();
	
	public Vehicle getVehicleByKey(Integer key);

	public Vehicle persistVehicle(Integer key, Vehicle vehicle);

	public Vehicle updateVehicle(Integer key, Vehicle vehicle);

	public Vehicle deleteVehicle(Integer key);
	
}
