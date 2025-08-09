package com.hexaware.fastx_busticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.Trip;

public interface TripRepo extends JpaRepository<Trip,Integer> {

	List<Trip> findByRouteRouteId(int routeId);
	

}
