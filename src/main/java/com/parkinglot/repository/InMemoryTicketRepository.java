package com.parkinglot.repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.parkinglot.model.ParkingTicket;

public class InMemoryTicketRepository implements TicketRepository {
    private final Map<String, ParkingTicket> ticketStorage = new HashMap<>();
    @Override
    public void save(ParkingTicket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null.");
        }
        if (ticketStorage.containsKey(ticket.getTicketId())) {
            throw new IllegalArgumentException("Ticket with this ID already exists.");
        }
        ticketStorage.put(ticket.getTicketId(), ticket);
    }

    @Override
    public Optional<ParkingTicket> findById(String ticketId) {
        if (ticketId == null || ticketId.isEmpty()) {
            throw new IllegalArgumentException("Ticket ID cannot be null or empty.");
        }
        return Optional.ofNullable(ticketStorage.get(ticketId));
    }

}
