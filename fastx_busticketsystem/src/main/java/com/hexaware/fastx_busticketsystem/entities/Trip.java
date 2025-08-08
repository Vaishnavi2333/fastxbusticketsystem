package com.hexaware.fastx_busticketsystem.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Trip {
	
	@Id
	private int tripId;
    private int busId;
    private int routeId;
    private LocalDate date;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private double fare;
    private String status;
    
    @ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;
    
    @ManyToOne
    @JoinColumn(name = "bus_id") 
    private Bus bus;
    
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();
    
    
	public Trip(int tripId, int busId, int routeId, LocalDate date, LocalTime departureTime, LocalTime arrivalTime,
			double fare, String status) {
		super();
		this.tripId = tripId;
		this.busId = busId;
		this.routeId = routeId;
		this.date = date;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
		this.status = status;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	public List<Booking> getBookings() {
	    return bookings;
	}

	public void setBookings(List<Booking> bookings) {
	    this.bookings = bookings;
	}
	
	public void addBooking(Booking booking) {
	    bookings.add(booking);
	    booking.setTrip(this);
	}

	public void removeBooking(Booking booking) {
	    bookings.remove(booking);
	    booking.setTrip(null);
	}
    

}
