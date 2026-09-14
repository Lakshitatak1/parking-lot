package com.parkinglot.service;
import java.time.Clock;

import com.parkinglot.model.ParkingLot;
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

}
