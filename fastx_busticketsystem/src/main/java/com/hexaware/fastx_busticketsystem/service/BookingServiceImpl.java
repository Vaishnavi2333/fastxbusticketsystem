package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BookingDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BookingRepo;

@Service
public class BookingServiceImpl implements IBookingService{
	
	@Autowired
	BookingRepo bookingRepo;

	@Override
	public Booking addBooking(BookingDto bookingdto) {
		Booking booking = new Booking();
		booking.setBookingId(bookingdto.getBookingId());
		booking.setBookingDate(bookingdto.getBookingDate());
		booking.setStatus(bookingdto.getStatus());
		return bookingRepo.save(booking);
	}

	@Override
	public Booking updateBooking(BookingDto bookingdto) throws BookingNotFoundException {
		 Booking existingBooking = bookingRepo.findById(bookingdto.getBookingId())
	                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingdto.getBookingId()));

	        existingBooking.setBookingDate(bookingdto.getBookingDate());
	        existingBooking.setStatus(bookingdto.getStatus());
	       

	        return bookingRepo.save(existingBooking);
	}

	@Override
	public void cancelBooking(int bookingId) throws BookingNotFoundException {
		Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
        bookingRepo.delete(booking);
		
	}

	@Override
	public Booking getBookingById(int bookingId) throws BookingNotFoundException {
		 return bookingRepo.findById(bookingId)
	                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
	    
	}

	@Override
	public List<Booking> getAllBookings() {
		 return bookingRepo.findAll();
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		 return bookingRepo.findByUserUserId(userId); 
	}


}
