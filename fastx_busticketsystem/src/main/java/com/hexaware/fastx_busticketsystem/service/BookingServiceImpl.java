package com.hexaware.fastx_busticketsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BookingDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.Payment;
import com.hexaware.fastx_busticketsystem.entities.Trip;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BookingRepo;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;
import com.hexaware.fastx_busticketsystem.repository.PaymentRepo;
import com.hexaware.fastx_busticketsystem.repository.TripRepo;
import com.hexaware.fastx_busticketsystem.repository.UserDataRepo;


@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private UserDataRepo userRepo;

    @Autowired
    private TripRepo tripRepo;
    
    @Autowired
    BusRepo busRepo;
    
    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public Booking addBooking(BookingDto bookingDto) {
        UserData user = userRepo.findById(bookingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + bookingDto.getUserId()));

        Trip trip = tripRepo.findById(bookingDto.getTripId())
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + bookingDto.getTripId()));

       
        List<String> bookedSeats = bookingRepo.findByTrip_TripId(trip.getTripId())
                .stream()
                .flatMap(b -> b.getSelectedSeats().stream())
                .collect(Collectors.toList());

        List<String> requestedSeats = bookingDto.getSelectedSeats();
        for (String seat : requestedSeats) {
            if (bookedSeats.contains(seat)) {
                throw new RuntimeException("Seat " + seat + " is already booked");
            }
        }

      
        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setStatus("Pending");
        booking.setUser(user);
        booking.setTrip(trip);
        booking.setSelectedSeats(requestedSeats);

        
        double totalPrice = requestedSeats.size() * trip.getFare();
        booking.setTotalPrice(totalPrice);

        return bookingRepo.save(booking);
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
        return bookingRepo.findByUser_UserdataId(userId);
    }

    @Override
    public List<String> getAvailableSeats(int tripId, LocalDate date) {
        List<String> bookedSeats = bookingRepo.findByTrip_TripId(tripId)
                .stream()
                .flatMap(b -> b.getSelectedSeats().stream())
                .collect(Collectors.toList());

        List<String> allSeats = IntStream.rangeClosed(1, 40)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        allSeats.removeAll(bookedSeats);
        return allSeats;
    }

    @Override
    public List<Booking> getBookingsByOperator(int operatorId) {
        
        List<Bus> buses = busRepo.findByBusOpData_BusOpdataId(operatorId);

       
        List<Booking> bookings = new ArrayList<>();
        for (Bus bus : buses) {
            List<Trip> trips = tripRepo.findByBusBusId(bus.getBusId());
            for (Trip trip : trips) {
                bookings.addAll(bookingRepo.findByTrip_TripId(trip.getTripId()));
            }
        }

        return bookings;
    }

    @Override
    public void refundBookingByOperator(int bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

       
        booking.setStatus("Cancelled");
        bookingRepo.save(booking);

        
        if (booking.getPayment() != null) {
            Payment payment = booking.getPayment();
            payment.setStatus("Refunded");
            paymentRepo.save(payment);
        }
    }

}


