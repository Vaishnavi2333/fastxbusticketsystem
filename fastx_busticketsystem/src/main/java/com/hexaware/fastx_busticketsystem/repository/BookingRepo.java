package com.hexaware.fastx_busticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.Booking;

public interface BookingRepo extends JpaRepository<Booking,Integer> {

}
