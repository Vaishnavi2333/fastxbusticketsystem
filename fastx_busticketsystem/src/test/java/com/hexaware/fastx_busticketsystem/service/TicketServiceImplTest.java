package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.TicketDto;
import com.hexaware.fastx_busticketsystem.entities.Ticket;
import com.hexaware.fastx_busticketsystem.exception.TicketNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.TicketRepo;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class TicketServiceImplTest {

    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private TicketRepo ticketRepo;

    private Ticket savedTicket;

    @BeforeEach
    void setup() {
       
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setSeatNumber(10);
        ticket.setFare(500.0);
        savedTicket = ticketRepo.save(ticket);
    }

    @Test
    void testGenerateTicket() {
        TicketDto dto = new TicketDto();
        dto.setTicketId(2);
        dto.setSeatNumber(15);
        dto.setFare(600.0);

        Ticket ticket = ticketService.generateTicket(dto);

        assertNotNull(ticket);
        assertEquals(dto.getTicketId(), ticket.getTicketId());
        assertEquals(dto.getSeatNumber(), ticket.getSeatNumber());
        assertEquals(dto.getFare(), ticket.getFare());
    }

    @Test
    void testUpdateTicket() throws TicketNotFoundException {
        TicketDto dto = new TicketDto();
        dto.setTicketId(savedTicket.getTicketId());
        dto.setSeatNumber(20);
        dto.setFare(650.0);

        Ticket updated = ticketService.updateTicket(dto);

        assertNotNull(updated);
        assertEquals(20, updated.getSeatNumber());
        assertEquals(650.0, updated.getFare());
    }

    @Test
    void testUpdateTicketThrowsException() {
        TicketDto dto = new TicketDto();
        dto.setTicketId(999); // Non-existent ticket
        dto.setSeatNumber(5);
        dto.setFare(400.0);

        assertThrows(TicketNotFoundException.class, () -> ticketService.updateTicket(dto));
    }

    @Test
    void testCancelTicket() throws TicketNotFoundException {
        ticketService.cancelTicket(savedTicket.getTicketId());

        assertFalse(ticketRepo.findById(savedTicket.getTicketId()).isPresent());
    }

    @Test
    void testCancelTicketThrowsException() {
        assertThrows(TicketNotFoundException.class, () -> ticketService.cancelTicket(999));
    }

    @Test
    void testGetTicketById() throws TicketNotFoundException {
        Ticket ticket = ticketService.getTicketById(savedTicket.getTicketId());

        assertNotNull(ticket);
        assertEquals(savedTicket.getTicketId(), ticket.getTicketId());
    }

    @Test
    void testGetTicketByIdThrowsException() {
        assertThrows(TicketNotFoundException.class, () -> ticketService.getTicketById(999));
    }

    @Test
    void testGetTicketsByBookingId() {
        
        List<Ticket> tickets = ticketService.getTicketsByBookingId(0);

       
        assertTrue(tickets.isEmpty());
    }
}