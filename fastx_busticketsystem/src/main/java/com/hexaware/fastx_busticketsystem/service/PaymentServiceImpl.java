package com.hexaware.fastx_busticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.PaymentDto;
import com.hexaware.fastx_busticketsystem.entities.Payment;
import com.hexaware.fastx_busticketsystem.exception.PaymentNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.PaymentRepo;


@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	PaymentRepo repo;

	@Override
	public Payment makePayment(PaymentDto paymentDto) {
		Payment pay = new Payment();
		pay.setPaymentId(paymentDto.getPaymentId());
		pay.setAmount(paymentDto.getAmount());
		pay.setPaymentDate(paymentDto.getPaymentDate());
		pay.setPaymentMethod(paymentDto.getPaymentMethod());
		pay.setStatus(paymentDto.getStatus());
		
		return repo.save(pay);
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		return repo.findById(paymentId)
		        .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + paymentId));
	}

	@Override
	public Payment getPaymentByBookingId(int bookingId) {
		 return repo.findByBooking_BookingId(bookingId)
			        .orElseThrow(() -> new PaymentNotFoundException("Payment not found for booking id: " + bookingId));
	}

	@Override
	public void refundPayment(int paymentId) {
		Payment payment = repo.findById(paymentId)
		        .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + paymentId));
		    payment.setStatus("Refunded");
		    repo.save(payment);
		
	}

	

}
