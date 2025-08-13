package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.dto.TicketDto;
import com.hexaware.fastx_busticketsystem.entities.Ticket;
import com.hexaware.fastx_busticketsystem.exception.TicketNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.TripNotFoundException;

public interface ITicketService {
	

Ticket generateTicket(TicketDto ticketDto);
	
    Ticket updateTicket(TicketDto ticketDto) throws TicketNotFoundException;
    
    void cancelTicket(int ticketId) throws TicketNotFoundException;
    
    Ticket getTicketById(int ticketId) throws TicketNotFoundException;
    
    List<Ticket> getTicketsByBookingId(int bookingId);
}
