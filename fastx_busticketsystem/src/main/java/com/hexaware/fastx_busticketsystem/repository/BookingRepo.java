package com.hexaware.fastx_busticketsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.entities.UserData;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
	
	List<Booking> findByUser_UserdataId(int userId);

    
    List<Booking> findByTrip_TripId(int tripId);

}
