package com.parkinglot.model;
import com.parkinglot.enums.TicketStatus;
public class ParkingTicket {

    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTime;
    private TicketStatus ticketStatus;
    private long exitTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, long entryTime) {
        if(ticketId == null || ticketId.isEmpty()) {
            throw new IllegalArgumentException("Ticket ID cannot be null or empty.");
        }
        if(vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        if(parkingSpot == null) {
            throw new IllegalArgumentException("Parking spot cannot be null.");
        }
        if(entryTime < 0) {
            throw new IllegalArgumentException("Entry time cannot be negative.");
        }
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.exitTime = -1; // Initialize exit time to -1 indicating the vehicle is still parked
        this.ticketStatus = TicketStatus.ACTIVE;
    }
    public void markAsCompleted(long exitTime) {
        if (this.ticketStatus == TicketStatus.COMPLETED) {
            throw new IllegalStateException("Ticket is already completed.");
        }
        if(exitTime < entryTime) {
            throw new IllegalArgumentException("Exit time cannot be before entry time.");
        }
        this.exitTime = exitTime;
        this.ticketStatus = TicketStatus.COMPLETED;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public long getExitTime() {
        return exitTime;
    }

}
