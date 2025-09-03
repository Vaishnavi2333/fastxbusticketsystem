package com.hexaware.fastx_busticketsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class BookingSummaryDTO {
    private int bookingId;
    private String status;
    private LocalDate bookingDate;
    private String busName;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private String username;       // added
    private List<String> seatsBooked;     // optional
    private double totalAmount;    // optional

    // Constructors
    public BookingSummaryDTO() {}
    
    public BookingSummaryDTO(int bookingId, String status, LocalDate bookingDate,
            String busName, LocalTime startingTime, LocalTime endingTime) {
this.bookingId = bookingId;
this.status = status;
this.bookingDate = bookingDate;
this.busName = busName;
this.startingTime = startingTime;
this.endingTime = endingTime;
}


    public BookingSummaryDTO(int bookingId, String status, LocalDate bookingDate,
            String busName, LocalTime startingTime, LocalTime endingTime,
            String username, List<String> seatsBooked, double totalAmount) {
this.bookingId = bookingId;
this.status = status;
this.bookingDate = bookingDate;
this.busName = busName;
this.startingTime = startingTime;
this.endingTime = endingTime;
this.username = username;
this.seatsBooked = seatsBooked;
this.totalAmount = totalAmount;
}

    // Getters & Setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public String getBusName() { return busName; }
    public void setBusName(String busName) { this.busName = busName; }

    public LocalTime getStartingTime() { return startingTime; }
    public void setStartingTime(LocalTime startingTime) { this.startingTime = startingTime; }

    public LocalTime getEndingTime() { return endingTime; }
    public void setEndingTime(LocalTime endingTime) { this.endingTime = endingTime; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

   

    public List<String> getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(List<String> seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
