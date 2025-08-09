package com.hexaware.fastx_busticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.Booking;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
	
	List<Booking> findByUserUserId(int userId);

}
