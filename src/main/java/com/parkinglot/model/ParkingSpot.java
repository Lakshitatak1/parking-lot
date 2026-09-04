package com.parkinglot.model;

import com.parkinglot.enums.SpotType;

public class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;
    private Vehicle vehicle;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        if(this.vehicle != null) {
            throw new IllegalStateException("Parking spot is already occupied.");
        }
        if(vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        if(this.vehicle == null) {
            throw new IllegalStateException("Parking spot is already empty.");
        }
        this.vehicle = null;
    }
    public boolean isAvailable() {
        return this.vehicle == null;
    }
}
