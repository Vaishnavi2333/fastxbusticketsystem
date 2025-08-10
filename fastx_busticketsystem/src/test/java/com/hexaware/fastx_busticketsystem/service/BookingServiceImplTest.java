package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BookingDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;

@SpringBootTest
class BookingServiceImplTest {
	
	@Autowired
	IBookingService bookingService;

	@Test
	void testAddBooking() {
		BookingDto bookingDto = new BookingDto();
		bookingDto.setBookingId(1);
	    bookingDto.setBookingDate(LocalDate.now());
	    bookingDto.setStatus("Confirmed");
	    

	    Booking savedBooking = bookingService.addBooking(bookingDto);

	    
	    assertEquals("Confirmed", savedBooking.getStatus());
	    
	}

	@Disabled
	@Test
	void testCancelBooking() {
		
	}

	@Disabled
	@Test
	void testGetBookingById() throws BookingNotFoundException {
		int bookingId = 1; 
	    Booking booking = bookingService.getBookingById(bookingId);
	    assertNotNull(booking);
	    assertEquals(bookingId, booking.getBookingId());
	}

}
