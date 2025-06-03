package org.example.movie_theater_2.controller;

import org.example.movie_theater_2.model.Ticket;
import org.example.movie_theater_2.repository.TicketRepository;
import org.example.movie_theater_2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> buyTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.buyTicket(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @GetMapping("/by-customer")
    public ResponseEntity<List<Ticket>> getTicketsByCustomer(@RequestParam String customerName) {
        List<Ticket> tickets = ticketService.getTicketsByCustomerName(customerName);
        if (tickets.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/view")
    public String viewTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "tickets";
    }
}
