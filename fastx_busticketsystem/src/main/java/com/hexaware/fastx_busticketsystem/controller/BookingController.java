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

import com.hexaware.fastx_busticketsystem.dto.BookingDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IBookingService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	IBookingService service;
	
	
	 @PostMapping("/add")
	    public Booking addBooking(@RequestBody @Valid BookingDto bookingDto) {
	        return service.addBooking(bookingDto);
	    }
	 
	 @PutMapping("/update/{id}")
	    public Booking updateBooking(@PathVariable("id") int bookingId,
	                                 @RequestBody @Valid BookingDto bookingDto) throws BookingNotFoundException {
	        bookingDto.setBookingId(bookingId);
	        return service.updateBooking(bookingDto);
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public void cancelBooking(@PathVariable("id") int bookingId) throws BookingNotFoundException {
	        service.cancelBooking(bookingId);
	    }
	 
	 @GetMapping("/getbyid/{id}")
	    public Booking getBookingById(@PathVariable("id") int bookingId) throws BookingNotFoundException {
	        return service.getBookingById(bookingId);
	    }
	 
	 @GetMapping("/getall")
	    public List<Booking> getAllBookings() {
	        return service.getAllBookings();
	    }
	 
	 @GetMapping("/user/{userId}")
	    public List<Booking> getBookingsByUserId(@PathVariable("userId") int userId) {
	        return service.getBookingsByUserId(userId);
	    }
	 

}
