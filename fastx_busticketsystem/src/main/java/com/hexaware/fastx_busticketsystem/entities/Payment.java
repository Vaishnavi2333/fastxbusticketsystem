package com.hexaware.fastx_busticketsystem.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	 @Id
	 private int paymentId;
	 private double amount;
	 private LocalDate paymentDate;
	 private String paymentMethod;
	 private String status;
	 
	 @OneToOne(mappedBy = "payment")
	 private Booking booking;
	 
	 public Payment() {
		 
	 }
	 
	 
	 public Payment(int paymentId,  double amount, LocalDate paymentDate, String paymentMethod,
			String status) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.status = status;
	 }
	 public int getPaymentId() {
		 return paymentId;
	 }
	 public void setPaymentId(int paymentId) {
		 this.paymentId = paymentId;
	 }
	 public double getAmount() {
		 return amount;
	 }
	 public void setAmount(double amount) {
		 this.amount = amount;
	 }
	 public LocalDate getPaymentDate() {
		 return paymentDate;
	 }
	 public void setPaymentDate(LocalDate paymentDate) {
		 this.paymentDate = paymentDate;
	 }
	 public String getPaymentMethod() {
		 return paymentMethod;
	 }
	 public void setPaymentMethod(String paymentMethod) {
		 this.paymentMethod = paymentMethod;
	 }
	 public String getStatus() {
		 return status;
	 }
	 public void setStatus(String status) {
		 this.status = status;
	 }
	
	 public Booking getBooking() {
		    return booking;
		}

		public void setBooking(Booking booking) {
		    this.booking = booking;
		}
}
