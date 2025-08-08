package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.Ticket;

public interface ITicketService {
	
	Ticket generateTicket(Ticket ticket);
	
    Ticket updateTicket(int ticketId, Ticket updatedTicket);
    
    void cancelTicket(int ticketId);
    
    Ticket getTicketById(int ticketId);
    
    List<Ticket> getTicketsByBookingId(int bookingId);

}
