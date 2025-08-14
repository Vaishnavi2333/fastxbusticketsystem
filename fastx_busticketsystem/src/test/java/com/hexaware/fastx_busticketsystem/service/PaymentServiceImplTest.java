package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.PaymentDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.entities.Payment;
import com.hexaware.fastx_busticketsystem.exception.PaymentNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BookingRepo;
import com.hexaware.fastx_busticketsystem.repository.PaymentRepo;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class PaymentServiceImplTest {

	    @Autowired
	    private PaymentServiceImpl paymentService;

	    @Autowired
	    private PaymentRepo paymentRepo;

	    @Autowired
	    private BookingRepo bookingRepo;

	    private Booking savedBooking;

	    @BeforeEach
	    void setup() {
	        // Create a sample booking for testing
	        Booking booking = new Booking();
	        booking.setBookingId(1);
	        booking.setStatus("Pending");
	        savedBooking = bookingRepo.save(booking);
	    }

	    @Test
	    void testMakePayment() {
	        PaymentDto dto = new PaymentDto();
	        dto.setBookingId(savedBooking.getBookingId());
	        dto.setAmount(1500.0);
	        dto.setPaymentDate(LocalDate.now());
	        dto.setPaymentMethod("UPI");
	        dto.setBooking(savedBooking);

	        Payment payment = paymentService.makePayment(dto);

	        assertNotNull(payment);
	        assertEquals(1500.0, payment.getAmount());
	        assertEquals("Paid", payment.getStatus());
	        assertEquals("UPI", payment.getPaymentMethod());

	        // Check that booking is updated
	        Booking updatedBooking = bookingRepo.findById(savedBooking.getBookingId()).get();
	        assertEquals("Confirmed", updatedBooking.getStatus());
	    }

	    @Test
	    void testMakePaymentThrowsException() {
	        PaymentDto dto = new PaymentDto();
	        dto.setBookingId(999); // non-existent booking
	        dto.setAmount(1000.0);
	        dto.setPaymentDate(LocalDate.now());
	        dto.setPaymentMethod("UPI");

	        assertThrows(RuntimeException.class, () -> paymentService.makePayment(dto));
	    }

	    @Test
	    void testGetPaymentById() {
	        Payment payment = new Payment();
	        payment.setAmount(2000.0);
	        payment.setPaymentDate(LocalDate.now());
	        payment.setPaymentMethod("Card");
	        payment.setStatus("Paid");
	        payment.setBooking(savedBooking);
	        Payment savedPayment = paymentRepo.save(payment);

	        Payment fetched = paymentService.getPaymentById(savedPayment.getPaymentId());

	        assertNotNull(fetched);
	        assertEquals(savedPayment.getPaymentId(), fetched.getPaymentId());
	    }

	    @Test
	    void testGetPaymentByIdThrowsException() {
	        assertThrows(PaymentNotFoundException.class, () -> paymentService.getPaymentById(999));
	    }

	    @Test
	    void testGetPaymentByBookingId() {
	        Payment payment = new Payment();
	        payment.setAmount(1200.0);
	        payment.setPaymentDate(LocalDate.now());
	        payment.setPaymentMethod("UPI");
	        payment.setStatus("Paid");
	        payment.setBooking(savedBooking);
	        Payment savedPayment = paymentRepo.save(payment);

	        Payment fetched = paymentService.getPaymentByBookingId(savedBooking.getBookingId());

	        assertNotNull(fetched);
	        assertEquals(savedPayment.getPaymentId(), fetched.getPaymentId());
	    }

	    @Test
	    void testGetPaymentByBookingIdThrowsException() {
	        assertThrows(PaymentNotFoundException.class, () -> paymentService.getPaymentByBookingId(999));
	    }

	    @Test
	    void testRefundPayment() {
	        Payment payment = new Payment();
	        payment.setAmount(1300.0);
	        payment.setPaymentDate(LocalDate.now());
	        payment.setPaymentMethod("Card");
	        payment.setStatus("Paid");
	        payment.setBooking(savedBooking);
	        Payment savedPayment = paymentRepo.save(payment);

	        paymentService.refundPayment(savedPayment.getPaymentId());

	        Payment refunded = paymentRepo.findById(savedPayment.getPaymentId()).get();
	        assertEquals("Refunded", refunded.getStatus());
	    }

	    @Test
	    void testRefundPaymentThrowsException() {
	        assertThrows(PaymentNotFoundException.class, () -> paymentService.refundPayment(999));
	    }
	}

