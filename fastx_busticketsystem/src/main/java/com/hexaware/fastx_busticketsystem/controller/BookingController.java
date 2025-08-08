package com.hexaware.fastx_busticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.repository.BookingRepo;

@RestController
@RequestMapping
public class BookingController {
	
	@Autowired
	BookingRepo repo;

}
