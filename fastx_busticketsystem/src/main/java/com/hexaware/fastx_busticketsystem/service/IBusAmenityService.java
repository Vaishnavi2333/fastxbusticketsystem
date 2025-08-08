package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.BusAmenity;

public interface IBusAmenityService {
	
	public BusAmenity addBusAmenity(BusAmenity busamenity);
	
	public BusAmenity updateBusAmenity(BusAmenity busamenity);
	
	public void removeBusAmenity(int busAmenityId);
	
	public List<BusAmenity> getAllBusAmenity();
	
	 public BusAmenity getBusAmenityById(int busAmenityId);

}
