package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;

public interface IBusService {
	
	public Bus addBus(BusDto busDto);
	
    public Bus updateBus( BusDto busDto) throws BusNotFoundException;
    
    public void deleteBus(int busId) throws BusNotFoundException;
    
    public Bus getBusById(int busId) throws BusNotFoundException;
    
    public List<Bus> getAllBuses();
    
    public List<Bus> getBusesByOperatorId(int operatorId);
    

}
