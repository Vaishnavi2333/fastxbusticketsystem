package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.Booking;

public interface IBookingService {
	
	public Booking addBooking(Booking booking);
	
	   public  Booking updateBooking(int bookingId, Booking updatedBooking);
	    public void cancelBooking(int bookingId);
	    
	    public Booking getBookingById(int bookingId);
	    
	    public List<Booking> getAllBookings();
	    
	    public List<Booking> getBookingsByUserId(int userId);
	

}
