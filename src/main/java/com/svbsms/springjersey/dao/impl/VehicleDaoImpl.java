package com.svbsms.springjersey.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.svbsms.springjersey.dao.VehicleDao;
import com.svbsms.springjersey.exception.CustomException;
import com.svbsms.springjersey.rest.model.Vehicle;

@Repository(value = "vehicleDao")
public class VehicleDaoImpl implements VehicleDao {
	
	private static Map<Integer, Vehicle> vehiclesRepository;
		
	public VehicleDaoImpl(){
		vehiclesRepository = new HashMap<Integer, Vehicle>();
		vehiclesRepository.put(123, new Vehicle(123, 1960, "WolksWagon", "Beats"));
		vehiclesRepository.put(456, new Vehicle(456, 1961, "Toyota", "Corolla"));
		vehiclesRepository.put(789, new Vehicle(789, 1962, "WolksWagon", "Beats"));
	}
	
	public List<Vehicle> getVehicles() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if(!vehiclesRepository.isEmpty()){
			for(Integer ids : vehiclesRepository.keySet()){
				vehicles.add(vehiclesRepository.get(ids));
			}
		}
		return vehicles;
	}

	public Vehicle getVehicleByKey(Integer key) {
		System.out.println("In DAO getVehicleByKey");
		if(null != vehiclesRepository.get(key))
			return vehiclesRepository.get(key);
		return null;
	}

	public Vehicle persistVehicle(Integer key, Vehicle vehicle) {
		if(vehiclesRepository.containsKey(key)){
			throw new CustomException();
//			return null;
		}
		return vehiclesRepository.put(key, vehicle);
	}

	public Vehicle updateVehicle(Integer key, Vehicle vehicle) {
		Vehicle updatesVehicle = null;
		if(vehiclesRepository.containsKey(key)){
			updatesVehicle = vehiclesRepository.replace(key, vehicle);
			return updatesVehicle;
		}
		throw new CustomException();
//		return updatesVehicle;
	}

	public Vehicle deleteVehicle(Integer key) {
		if(vehiclesRepository.containsKey(key))
			return vehiclesRepository.remove(key);
		throw new CustomException();
//		return null;
	}

	@Override
	public List<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if(!vehiclesRepository.isEmpty()){
			for(Integer ids : vehiclesRepository.keySet()){
				if(vehiclesRepository.get(ids).getMake().equals(make) && vehiclesRepository.get(ids).getModel().equals(model))
					vehicles.add(vehiclesRepository.get(ids));
			}
		}
		return vehicles;
	}

}
