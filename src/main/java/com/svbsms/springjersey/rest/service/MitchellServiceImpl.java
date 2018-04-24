package com.svbsms.springjersey.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svbsms.springjersey.dao.VehicleDao;
import com.svbsms.springjersey.rest.model.Vehicle;

@Service(value = "mitchellService")
public class MitchellServiceImpl implements MitchellService {

	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public Vehicle getVehicle(int id) {
		return vehicleDao.getVehicleByKey(id);
	}

	@Override
	public List<Vehicle> getVehicles() {		
		return vehicleDao.getVehicles();
	}

	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleDao.persistVehicle(vehicle.getId(), vehicle);
	}

	@Override
	public void updateVehicleDetails(Vehicle vehicle) {
		vehicleDao.updateVehicle(vehicle.getId(), vehicle);
	}

	@Override
	public void deleteVehicle(int id) {
		vehicleDao.deleteVehicle(id);
	}


}
