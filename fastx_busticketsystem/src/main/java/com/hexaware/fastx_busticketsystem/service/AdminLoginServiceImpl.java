package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.AdminLoginDto;
import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.AdminLogin;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.exception.AdminAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.AdminNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.RouteNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.AdminLoginRepo;
import com.hexaware.fastx_busticketsystem.repository.BookingRepo;
import com.hexaware.fastx_busticketsystem.repository.BusOpDataRepo;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;
import com.hexaware.fastx_busticketsystem.repository.RouteRepo;
import com.hexaware.fastx_busticketsystem.repository.UserDataRepo;

@Service
public class AdminLoginServiceImpl implements IAdminLoginService {
	
	 @Autowired
	    AdminLoginRepo adminRepo;

	    @Autowired
	    RouteRepo routeRepo;

	    @Autowired
	    BusRepo busRepo;
	    
	    @Autowired
	    UserDataRepo userRepo;
	    
	    @Autowired
	    BusOpDataRepo busOpRepo;
	    
	    @Autowired
	    BookingRepo bookingRepo;

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
	    public void deleteUser(int userId) throws UserNotFoundException {
	        UserData user = userRepo.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
	        userRepo.delete(user);
	    }

	    @Override
	    public List<UserData> getAllUsers() {
	        return userRepo.findAll();
	    }

	    @Override
	    public void deleteBusOperator(int operatorId) throws BusOperatorNotFoundException {
	        BusOpData operator = busOpRepo.findById(operatorId)
	            .orElseThrow(() -> new BusOperatorNotFoundException("Bus Operator not found with id: " + operatorId));
	        busOpRepo.delete(operator);
	    }

	    @Override
	    public List<BusOpData> getAllBusOperators() {
	        return busOpRepo.findAll();
	    }

	    @Override
	    public void deleteBooking(int bookingId) throws BookingNotFoundException {
	        Booking booking = bookingRepo.findById(bookingId)
	            .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + bookingId));
	        bookingRepo.delete(booking);
	    }

	    @Override
	    public List<Booking> getAllBookings() {
	        return bookingRepo.findAll();
	    }

	    @Override
	    public void deleteRoute(int routeId) throws RouteNotFoundException {
	        Route route = routeRepo.findById(routeId)
	            .orElseThrow(() -> new RouteNotFoundException("Route not found with id: " + routeId));
	        routeRepo.delete(route);
	    }

	    @Override
	    public List<Route> getAllRoutes() {
	        return routeRepo.findAll();
	    }

		@Override
		public boolean registerAdmin(AdminLoginDto adminDto) throws AdminAlreadyExistsException {
			
			 if (adminRepo.existsByUsername(adminDto.getUsername())) {
			        throw new AdminAlreadyExistsException("Admin with username '" + adminDto.getUsername() + "' already exists");
			    }
			    
			  
			    AdminLogin admin = new AdminLogin();
			    admin.setUsername(adminDto.getUsername());
			    admin.setPassword(adminDto.getPassword()); 
			    
			    adminRepo.save(admin);
			    return true;
		}

		@Override
		public boolean loginAdmin(String username, String password) throws AdminNotFoundException {
			
			AdminLogin admin = adminRepo.findByUsername(username);
		    if (admin == null) {
		        throw new AdminNotFoundException("Admin with username '" + username + "' not found");
		    }
		    
		    return true;
		}

		
}
