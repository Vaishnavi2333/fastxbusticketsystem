package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.AdminLoginRepo;
import com.hexaware.fastx_busticketsystem.service.IAdminLoginService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	  @Autowired 
	  IAdminLoginService service;
	  
	  
	  
	  @PostMapping("/addroute")
	    public Route addRoute(@RequestBody RouteDto routeDto) {
	        return service.addRoute(routeDto);
	    }

	   
	    @PostMapping("/addbus")
	    public Bus addBus(@RequestBody BusDto busDto) {
	        return service.addBus(busDto);
	    }

	    
	    @GetMapping("/buses")
	    public List<Bus> getAllBuses() {
	        return service.getAllBuses();
	    }

	    
	    @DeleteMapping("/bus/{busId}")
	    public String deleteBus(@PathVariable int busId) throws BusNotFoundException {
	        return service.deleteBus(busId);
	    }
	 
	

}
