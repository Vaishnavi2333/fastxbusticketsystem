package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.AdminLoginRepo;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;
import com.hexaware.fastx_busticketsystem.repository.RouteRepo;

@Service
public class AdminLoginServiceImpl implements IAdminLoginService {
	
	 @Autowired
	    private AdminLoginRepo adminRepo;

	    @Autowired
	    private RouteRepo routeRepo;

	    @Autowired
	    private BusRepo busRepo;

	    @Override
	    public Route addRoute(RouteDto routeDto) {
	    	
	    	Route route = new Route();
	    	route.setRouteId(routeDto.getRouteId());
	    	route.setRouteName(routeDto.getRouteName());
	    	route.setOrigin(routeDto.getOrigin());
	    	route.setDestination(routeDto.getDestination());
	    	route.setDistanceKm(routeDto.getDistanceKm());
	    	route.setEstimatedTime(route.getEstimatedTime());
	    	
	        return routeRepo.save(route); 
	    }

	    @Override
	    public Bus addBus(BusDto busDto) {
	    	
	    	Bus bus = new Bus();
	    	bus.setBusId(busDto.getBusId());
	    	bus.setBusNumber(bus.getBusNumber());
	    	bus.setBusName(bus.getBusName());
	    	bus.setBusType(busDto.getBusType());
	    	bus.setCapacity(busDto.getCapacity());
	    	bus.setStatus(busDto.getStatus());
	    	
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
