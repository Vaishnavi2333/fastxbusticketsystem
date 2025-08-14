package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.BusAmenityDto;
import com.hexaware.fastx_busticketsystem.entities.BusAmenity;
import com.hexaware.fastx_busticketsystem.exception.BusAmenityNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IBusAmenityService;

/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:12-Aug-2025
Description:Controller Class for BusAmenity*/

import jakarta.validation.Valid;

@RestController
@RequestMapping("/busamenity")
public class BusAmenityController {
	
	@Autowired
	IBusAmenityService service;
	
	@PreAuthorize("hasRole('USER')") 
	 @PostMapping("/add")
	    public BusAmenity addBusAmenity(@RequestBody @Valid BusAmenityDto dto) throws BusNotFoundException {
	        return service.addBusAmenity(dto);
	    }
        
	    @PreAuthorize("hasRole('USER')") 
	    @PutMapping("/update")
	    public BusAmenity updateBusAmenity(@RequestBody @Valid BusAmenityDto dto) throws BusAmenityNotFoundException, BusNotFoundException {
	        return service.updateBusAmenity(dto);
	    }

	    @PreAuthorize("hasRole('USER')") 
	    @DeleteMapping("/remove/{id}")
	    public String removeBusAmenity(@PathVariable("id") int id) {
	        service.removeBusAmenity(id);
	        return "BusAmenity with id " + id + " deleted successfully";
	    }

	    @PreAuthorize("hasRole('USER')") 
	    @GetMapping("/all")
	    public List<BusAmenity> getAllBusAmenities() {
	        return service.getAllBusAmenity();
	    }

	    @GetMapping("/getbyid/{id}")
	    public BusAmenity getBusAmenityById(@PathVariable("id") int id) {
	        return service.getBusAmenityById(id);
	    }

}
