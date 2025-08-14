package com.hexaware.fastx_busticketsystem.entities;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.fastx_busticketsystem.exception.TripNotFoundException;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:07-Aug-2025
Description:Ticket Entity Class*/

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	private int ticketId;
    private int seatNumber;
    private double fare;
    
    @ManyToOne
    @JoinColumn(name = "booking_id") 
    private Booking booking;
    
    public Ticket() {
    	
    }
	public Ticket(int ticketId, int seatNumber, double fare) {
		super();
		this.ticketId = ticketId;
		this.seatNumber = seatNumber;
		this.fare = fare;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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
