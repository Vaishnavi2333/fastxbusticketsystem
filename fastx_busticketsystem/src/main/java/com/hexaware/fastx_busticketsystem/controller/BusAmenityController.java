package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import jakarta.validation.Valid;

@RestController
@RequestMapping("/busamenity")
public class BusAmenityController {
	
	@Autowired
	IBusAmenityService service;
	
	 @PostMapping("/add")
	    public BusAmenity addBusAmenity(@RequestBody @Valid BusAmenityDto dto) throws BusNotFoundException {
	        return service.addBusAmenity(dto);
	    }

	    @PutMapping("/update")
	    public BusAmenity updateBusAmenity(@RequestBody @Valid BusAmenityDto dto) throws BusAmenityNotFoundException, BusNotFoundException {
	        return service.updateBusAmenity(dto);
	    }

	    @DeleteMapping("/remove/{id}")
	    public String removeBusAmenity(@PathVariable("id") int id) {
	        service.removeBusAmenity(id);
	        return "BusAmenity with id " + id + " deleted successfully";
	    }

	    @GetMapping("/all")
	    public List<BusAmenity> getAllBusAmenities() {
	        return service.getAllBusAmenity();
	    }

	    @GetMapping("/getbyid/{id}")
	    public BusAmenity getBusAmenityById(@PathVariable("id") int id) {
	        return service.getBusAmenityById(id);
	    }

}
