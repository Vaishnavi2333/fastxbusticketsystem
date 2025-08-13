package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.TicketDto;
import com.hexaware.fastx_busticketsystem.entities.Ticket;
import com.hexaware.fastx_busticketsystem.exception.TicketNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.TripNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.TicketRepo;


@Service
public class TicketServiceImpl implements ITicketService{
	
	@Autowired
	TicketRepo repo;

	@Override
	public Ticket generateTicket(TicketDto ticketDto) {
		Ticket ticket = new Ticket();
		ticket.setTicketId(ticketDto.getTicketId());
		ticket.setSeatNumber(ticketDto.getSeatNumber());
		ticket.setFare(ticketDto.getFare());
		return repo.save(ticket);
	}

	@Override
	public Ticket updateTicket(TicketDto ticketDto) throws TicketNotFoundException {
	    Ticket existing = repo.findById(ticketDto.getTicketId())
	        .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + ticketDto.getTicketId()));

	    existing.setSeatNumber(ticketDto.getSeatNumber());
	    existing.setFare(ticketDto.getFare());
	    return repo.save(existing);
	}

	@Override
	public void cancelTicket(int ticketId) throws TicketNotFoundException {
	    Ticket existing = repo.findById(ticketId)
	        .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + ticketId));
	    repo.delete(existing);
	}

	@Override
	public Ticket getTicketById(int ticketId) throws TicketNotFoundException {
	    return repo.findById(ticketId)
	        .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + ticketId));
	}

	@Override
	public List<Ticket> getTicketsByBookingId(int bookingId) {
	    return repo.findByBookingBookingId(bookingId);
	}

}
