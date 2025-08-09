package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.TripDto;
import com.hexaware.fastx_busticketsystem.dto.UserDataDto;
import com.hexaware.fastx_busticketsystem.entities.Trip;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.exception.TripNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.TripRepo;


@Service
public class TripServiceImpl implements ITripService {

	@Autowired
	TripRepo repo;


	@Override
	public Trip addTrip(TripDto tripDto) {
		Trip trip = new Trip();
		trip.setTripId(tripDto.getTripId());
		trip.setDate(tripDto.getDate());
		trip.setDepartureTime(trip.getDepartureTime());
		trip.setFare(tripDto.getFare());
		trip.setStatus(tripDto.getStatus());
		return repo.save(trip);
	}

	 @Override
	    public Trip updateTrip(TripDto tripDto) throws TripNotFoundException {
	        Trip existingTrip = repo.findById(tripDto.getTripId())
	                .orElseThrow(() -> new TripNotFoundException("Trip not found with id: " + tripDto.getTripId()));

	        existingTrip.setDate(tripDto.getDate());
	        existingTrip.setDepartureTime(tripDto.getDepartureTime());
	        existingTrip.setFare(tripDto.getFare());
	        existingTrip.setStatus(tripDto.getStatus());

	        return repo.save(existingTrip);
	    }

	    @Override
	    public void deleteTrip(int tripId) throws TripNotFoundException {
	        Trip existingTrip = repo.findById(tripId)
	                .orElseThrow(() -> new TripNotFoundException("Trip not found with id: " + tripId));
	        repo.delete(existingTrip);
	    }

	    @Override
	    public Trip getTripById(int tripId) throws TripNotFoundException {
	        return repo.findById(tripId)
	                .orElseThrow(() -> new TripNotFoundException("Trip not found with id: " + tripId));
	    }

	    @Override
	    public List<Trip> getAllTrips() {
	        return repo.findAll();
	    }

	    @Override
	    public List<Trip> getTripsByRoute(int routeId) {
	        
	        return repo.findByRouteRouteId(routeId);
	    }
	}




