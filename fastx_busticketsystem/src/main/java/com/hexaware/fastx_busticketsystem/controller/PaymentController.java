package com.hexaware.fastx_busticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.PaymentDto;
import com.hexaware.fastx_busticketsystem.entities.Payment;
import com.hexaware.fastx_busticketsystem.service.IPaymentService;

/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:10-Aug-2025
Description:Controller Class for Payment*/

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	IPaymentService service;
	

    @PostMapping("/make")
    public Payment makePayment(@RequestBody PaymentDto paymentDto) {
        return service.makePayment(paymentDto);
    }

    @GetMapping("getbyid/{paymentId}")
    public Payment getPaymentById(@PathVariable int paymentId) {
        return service.getPaymentById(paymentId);
    }

    @GetMapping("/booking/{bookingId}")
    public Payment getPaymentByBookingId(@PathVariable int bookingId) {
        return service.getPaymentByBookingId(bookingId);
    }

    @PutMapping("/refund/{paymentId}")
    public String refundPayment(@PathVariable int paymentId) {
        service.refundPayment(paymentId);
        return "Payment with ID " + paymentId + " has been refunded.";
    }

}
