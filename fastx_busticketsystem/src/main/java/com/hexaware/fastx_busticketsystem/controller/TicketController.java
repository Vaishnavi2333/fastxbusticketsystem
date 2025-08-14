package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.TicketDto;
import com.hexaware.fastx_busticketsystem.entities.Ticket;
import com.hexaware.fastx_busticketsystem.exception.TicketNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.TripNotFoundException;
import com.hexaware.fastx_busticketsystem.service.ITicketService;

import jakarta.validation.Valid;

/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:12-Aug-2025
Description:Controller Class for Ticket*/

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	ITicketService service;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/generate")
    public Ticket generateTicket(@Valid @RequestBody TicketDto ticketDto) {
        return service.generateTicket(ticketDto);
    }

	@PreAuthorize("hasRole('USER')")
    @PutMapping("/update")
    public Ticket updateTicket(@Valid @RequestBody TicketDto ticketDto) throws TicketNotFoundException {
        return service.updateTicket(ticketDto);
    }

	@PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/cancel/{ticketId}")
    public String cancelTicket(@PathVariable int ticketId) throws TicketNotFoundException, TripNotFoundException {
        service.cancelTicket(ticketId);
        return "Ticket with id " + ticketId + " cancelled successfully.";
    }

	@PreAuthorize("hasRole('USER')")
    @GetMapping("/getbyid/{ticketId}")
    public Ticket getTicketById(@PathVariable int ticketId) throws TicketNotFoundException {
        return service.getTicketById(ticketId);
    }

	@PreAuthorize("hasRole('USER')")
    @GetMapping("/booking/{bookingId}")
    public List<Ticket> getTicketsByBookingId(@PathVariable int bookingId) {
        return service.getTicketsByBookingId(bookingId);
    }

}
