package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.PaymentDto;
import com.hexaware.fastx_busticketsystem.entities.Payment;

@SpringBootTest
class PaymentServiceImplTest {
	
	@Autowired
    PaymentServiceImpl paymentService; 

	@Test
	void testMakePayment() {
		 PaymentDto dto = new PaymentDto();
	        dto.setPaymentId(2001);  
	        dto.setAmount(500.0);
	        dto.setPaymentDate(LocalDate.now());
	        dto.setPaymentMethod("Credit Card");
	        dto.setStatus("Completed");

	        Payment payment = paymentService.makePayment(dto);

	     
	        assertEquals(500.0, payment.getAmount());
	        assertEquals("Credit Card", payment.getPaymentMethod());
	     
	}

	@Test
	void testRefundPayment() {
		 PaymentDto dto = new PaymentDto();
		 dto.setPaymentId(2002);
	        dto.setAmount(300.0);
	        dto.setPaymentDate(LocalDate.now());
	        dto.setPaymentMethod("Cash");
	        dto.setStatus("Completed");
	        paymentService.makePayment(dto);

	    
	        paymentService.refundPayment(2002);

	        Payment refundedPayment = paymentService.getPaymentById(2002);

	        assertEquals("Refunded", refundedPayment.getStatus());
	}

}
