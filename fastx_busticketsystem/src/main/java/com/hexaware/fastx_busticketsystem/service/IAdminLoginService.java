package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;

public interface IAdminLoginService {
	
	public Route addRoute(Route route);

    public Bus addBus(Bus bus);

    public List<Bus> getAllBuses();

    public String deleteBus(int busId) throws BusNotFoundException;

}
