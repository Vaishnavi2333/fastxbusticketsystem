package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.Trip;

public interface ITripService {
	
	Trip addTrip(Trip trip);
    Trip updateTrip(int tripId, Trip updatedTrip);
    void deleteTrip(int tripId);
    Trip getTripById(int tripId);
    List<Trip> getAllTrips();
    List<Trip> getTripsByRoute(int routeId);

}
