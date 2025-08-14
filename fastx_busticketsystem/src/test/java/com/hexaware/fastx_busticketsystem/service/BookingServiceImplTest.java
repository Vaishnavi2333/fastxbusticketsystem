package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BookingDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BookingRepo;

class BookingServiceImplTest {
	@SpringBootTest
	class BookingServiceTest {

	    @Autowired
	    private IBookingService bookingService;

	    @Autowired
	    private BookingRepo bookingRepository;

	    @Test
	    void testAddBooking() {
	        BookingDto bookingDto = new BookingDto();
	        bookingDto.setBookingDate(LocalDate.now());
	        bookingDto.setStatus("Confirmed");

	        Booking saved = bookingService.addBooking(bookingDto);

	        assertNotNull(saved.getBookingId());
	        assertEquals("Confirmed", saved.getStatus());
	    }

	    @Test
	    void testGetBookingById() throws BookingNotFoundException {
	        Booking booking = new Booking();
	        booking.setBookingDate(LocalDate.now());
	        booking.setStatus("Confirmed");

	        Booking saved = bookingRepository.save(booking);

	        Booking fetched = bookingService.getBookingById(saved.getBookingId());
	        assertNotNull(fetched);
	        assertEquals(saved.getBookingId(), fetched.getBookingId());
	    }

	    @Test
	    void testGetAllBookings() {
	        List<Booking> bookings = bookingService.getAllBookings();
	        assertNotNull(bookings);
	        assertTrue(bookings.size() >= 0);
	    }
	}

}
