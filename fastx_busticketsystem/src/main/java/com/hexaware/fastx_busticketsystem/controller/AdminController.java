package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.AdminLoginDto;
import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.exception.AdminAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.AdminNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.RouteNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IAdminLoginService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	  @Autowired 
	  IAdminLoginService service;
	  
	  @PostMapping("/register")
	  public String registerAdmin(@RequestBody AdminLoginDto adminDto) throws AdminAlreadyExistsException {
	      boolean registered = service.registerAdmin(adminDto);
	      if (registered) {
	          return "Admin registered successfully";
	      } else {
	          return "Admin registration failed";
	      }
	  }

	  @PostMapping("/login")
	  public String loginAdmin(@RequestParam String username, @RequestParam String password) throws AdminNotFoundException{
	      boolean loggedIn = service.loginAdmin(username, password);
	      if (loggedIn) {
	          return "Admin login successful";
	      } else {
	          return "Admin login failed";
	      }
	  }
	  
	  @PostMapping("/addroute")
	    public Route addRoute(@RequestBody RouteDto routeDto) {
	        return service.addRoute(routeDto);
	    }

	    @DeleteMapping("/user/{userId}")
	    public String deleteUser(@PathVariable int userId) throws UserNotFoundException {
	        service.deleteUser(userId);
	        return "User with id " + userId + " deleted successfully.";
	    }

	    @GetMapping("/getallusers")
	    public List<UserData> getAllUsers() {
	        return service.getAllUsers();
	    }

	    @DeleteMapping("/operator/{operatorId}")
	    public String deleteBusOperator(@PathVariable int operatorId) throws BusOperatorNotFoundException {
	        service.deleteBusOperator(operatorId);
	        return "Bus operator with id " + operatorId + " deleted successfully.";
	    }

	    @GetMapping("/getalloperators")
	    public List<BusOpData> getAllBusOperators() {
	        return service.getAllBusOperators();
	    }

	    @DeleteMapping("/booking/{bookingId}")
	    public String deleteBooking(@PathVariable int bookingId) throws BookingNotFoundException {
	        service.deleteBooking(bookingId);
	        return "Booking with id " + bookingId + " deleted successfully.";
	    }

	    @GetMapping("/getallbookings")
	    public List<Booking> getAllBookings() {
	        return service.getAllBookings();
	    }

	    @DeleteMapping("/route/{routeId}")
	    public String deleteRoute(@PathVariable int routeId) throws RouteNotFoundException {
	        service.deleteRoute(routeId);
	        return "Route with id " + routeId + " deleted successfully.";
	    }

	    @GetMapping("/getallroutes")
	    public List<Route> getAllRoutes() {
	        return service.getAllRoutes();
	    }
}
