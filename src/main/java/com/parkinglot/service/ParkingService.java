package com.parkinglot.service;
import java.time.Clock;
import java.util.UUID;

import com.parkinglot.enums.TicketStatus;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingTicket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.strategy.SpotAllocationStrategy;

public class ParkingService {

    private final ParkingLot parkingLot;
    private final SpotAllocationStrategy spotAllocationStrategy;
    private final Clock clock;

    public ParkingService(ParkingLot parkingLot, SpotAllocationStrategy spotAllocationStrategy, Clock clock) {
        if (parkingLot == null) {
            throw new IllegalArgumentException("Parking lot cannot be null.");
        }
        if (spotAllocationStrategy == null) {
            throw new IllegalArgumentException("Spot allocation strategy cannot be null.");
        }
        if (clock == null) {
            throw new IllegalArgumentException("Clock cannot be null.");
        }
        this.parkingLot = parkingLot;
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.clock = clock;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if( vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        return spotAllocationStrategy.allocateSpot(parkingLot, vehicle)
                .map(spot -> {
                    spot.parkVehicle(vehicle);
                    long entryTime = clock.millis();
                    String ticketId = UUID.randomUUID().toString();
                    return new ParkingTicket(ticketId, vehicle, spot, entryTime);
                })
                .orElseThrow(() -> new IllegalStateException("No available parking spots for the vehicle type."));

    }

    public void unparkVehicle(ParkingTicket ticket) {
        if(ticket == null) {
            throw new IllegalArgumentException("Parking ticket cannot be null.");
        }
        if (ticket.getTicketStatus() == TicketStatus.COMPLETED) {
            throw new IllegalStateException("Ticket is already completed.");
        }
        long exitTime = clock.millis();
        ticket.getParkingSpot().removeVehicle();
        ticket.markAsCompleted(exitTime);
    }

}
