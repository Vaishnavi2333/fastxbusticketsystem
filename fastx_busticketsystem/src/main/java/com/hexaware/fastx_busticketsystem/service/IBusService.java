package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.Bus;

public interface IBusService {
	
	public Bus addBus(Bus bus);
	
    public Bus updateBus(int busId, Bus updatedBus);
    
    public void deleteBus(int busId);
    
    public Bus getBusById(int busId);
    
    public List<Bus> getAllBuses();
    
    public List<Bus> getBusesByOperatorId(int operatorId);
    

}
