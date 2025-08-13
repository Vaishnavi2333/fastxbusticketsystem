package com.hexaware.fastx_busticketsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.BookingDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IBookingService;

import jakarta.validation.Valid;


/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:12-Aug-2025
Description:Controller class for Booking*/



@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private IBookingService service;

   
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public Booking addBooking(@Valid @RequestBody BookingDto bookingDto) {
        return service.addBooking(bookingDto);
    }

   
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable int bookingId) throws BookingNotFoundException {
        service.cancelBooking(bookingId);
        return "Booking with ID " + bookingId + " has been cancelled.";
    }

   
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/get/{bookingId}")
    public Booking getBookingById(@PathVariable int bookingId) throws BookingNotFoundException {
        return service.getBookingById(bookingId);
    }

   
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable int userId) {
        return service.getBookingsByUserId(userId);
    }

   
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/available-seats/{tripId}")
    public List<String> getAvailableSeats(@PathVariable int tripId,
                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getAvailableSeats(tripId, date);
    }

   
    @PreAuthorize("hasRole('BUS_OPERATOR')")
    @GetMapping("/operator/{operatorId}")
    public List<Booking> getBookingsByOperator(@PathVariable int operatorId) {
        return service.getBookingsByOperator(operatorId);
    }

   
    @PreAuthorize("hasRole('BUS_OPERATOR')")
    @PutMapping("/refund/{bookingId}")
    public String refundBookingByOperator(@PathVariable int bookingId) {
        service.refundBookingByOperator(bookingId);
        return "Booking with ID " + bookingId + " has been refunded by operator.";
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }
}