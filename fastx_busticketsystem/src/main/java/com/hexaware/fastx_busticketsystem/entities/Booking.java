package com.hexaware.fastx_busticketsystem.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Booking {
	@Id
	private int bookingId;
    private int userId;
    private int tripId;
    private LocalDate bookingDate;
    private String status;
    
   
    
    @ManyToOne
    @JoinColumn(name = "user_id") 
    private UserData user;
    
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "trip_id") 
    private Trip trip;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id") 
    private Payment payment;
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminLogin admin;
    
	public Booking(int bookingId, int userId, int tripId, LocalDate bookingDate, String status) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.tripId = tripId;
		this.bookingDate = bookingDate;
		this.status = status;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public UserData getUser() {
	    return user;
	}

	public void setUser(UserData user) {
	    this.user = user;
	}

	public List<Ticket> getTickets() {
	    return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
	    this.tickets = tickets;
	}
	
	public Trip getTrip() {
	    return trip;
	}

	public void setTrip(Trip trip) {
	    this.trip = trip;
	}
	
	public Payment getPayment() {
	    return payment;
	}

	public void setPayment(Payment payment) {
	    this.payment = payment;
	}
	
	public void addTicket(Ticket ticket) {
	    tickets.add(ticket);
	    ticket.setBooking(this);
	}

	public void removeTicket(Ticket ticket) {
	    tickets.remove(ticket);
	    ticket.setBooking(null);
	}
    
    
    
}
	