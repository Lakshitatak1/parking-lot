package com.parkinglot.repository;
import java.util.Optional;

import com.parkinglot.model.ParkingTicket;
public interface TicketRepository {

    void save(ParkingTicket ticket);
    Optional<ParkingTicket> findById(String ticketId);
}
