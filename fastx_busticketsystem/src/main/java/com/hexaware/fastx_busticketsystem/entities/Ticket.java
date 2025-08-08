package com.hexaware.fastx_busticketsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
	
	@Id
	private int ticketId;
    private int bookingId;
    private int seatNumber;
    private double fare;
    
    @ManyToOne
    @JoinColumn(name = "booking_id") 
    private Booking booking;
    
	public Ticket(int ticketId, int bookingId, int seatNumber, double fare) {
		super();
		this.ticketId = ticketId;
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.fare = fare;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	public Booking getBooking() {
	    return booking;
	}

	public void setBooking(Booking booking) {
	    this.booking = booking;
	}

    
    

}
