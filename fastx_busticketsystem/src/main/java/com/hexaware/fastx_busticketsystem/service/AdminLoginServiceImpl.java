package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.AdminLoginRepo;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;
import com.hexaware.fastx_busticketsystem.repository.RouteRepo;

public class AdminLoginServiceImpl implements IAdminLoginService {
	
	 @Autowired
	    private AdminLoginRepo adminRepo;

	    @Autowired
	    private RouteRepo routeRepo;

	    @Autowired
	    private BusRepo busRepo;

	    @Override
	    public Route addRoute(Route route) {
	        return routeRepo.save(route); 
	    }

	    @Override
	    public Bus addBus(Bus bus) {
	        return busRepo.save(bus); 
	    }

	    @Override
	    public List<Bus> getAllBuses() {
	        return busRepo.findAll(); 
	    }



	@Override
	public String deleteBus(int busId) throws BusNotFoundException {
		
		 Bus bus = busRepo.findById(busId).orElse(null);

		    if (bus == null) {
		        throw new BusNotFoundException("Bus for given ID not found");
		         
		    }

		    busRepo.delete(bus);
		    return "Bus with ID: " + busId + " deleted successfully";
		 
		
		
		
	}

}
