package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.TripDto;
import com.hexaware.fastx_busticketsystem.entities.Trip;
import com.hexaware.fastx_busticketsystem.exception.TripNotFoundException;
import com.hexaware.fastx_busticketsystem.service.ITripService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping
public class TripController {
	
	@Autowired
	ITripService service;
	
	  @PostMapping
	    public Trip addTrip(@RequestBody TripDto tripDto) {
	        return service.addTrip(tripDto);
	    }

	    @PutMapping
	    public Trip updateTrip(@RequestBody TripDto tripDto) throws TripNotFoundException {
	        return service.updateTrip(tripDto);
	    }

	    @DeleteMapping("/{tripId}")
	    public String deleteTrip(@PathVariable int tripId) throws TripNotFoundException {
	        service.deleteTrip(tripId);
	        return "Trip with ID " + tripId + " deleted successfully.";
	    }

	    @GetMapping("/{tripId}")
	    public Trip getTripById(@PathVariable int tripId) throws TripNotFoundException {
	        return service.getTripById(tripId);
	    }

	    @GetMapping
	    public List<Trip> getAllTrips() {
	        return service.getAllTrips();
	    }

	    @GetMapping("/route/{routeId}")
	    public List<Trip> getTripsByRoute(@PathVariable int routeId) {
	        return service.getTripsByRoute(routeId);
	    }

}
