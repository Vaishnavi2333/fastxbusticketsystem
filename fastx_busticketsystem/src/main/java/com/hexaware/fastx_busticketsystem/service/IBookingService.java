package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.dto.BookingDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;

public interface IBookingService {
	
	public Booking addBooking(BookingDto bookingdto);
	
	public Booking updateBooking(BookingDto bookingdto) throws BookingNotFoundException;
	
	
	    public void cancelBooking(int bookingId) throws BookingNotFoundException;
	    
	    public Booking getBookingById(int bookingId) throws BookingNotFoundException;
	    
	    public List<Booking> getAllBookings();
	    
	    public List<Booking> getBookingsByUserId(int userId);
	

}
