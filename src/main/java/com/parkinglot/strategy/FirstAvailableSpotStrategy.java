package com.parkinglot.strategy;
import java.util.Optional;

import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;
public class FirstAvailableSpotStrategy implements SpotAllocationStrategy {

    private final SpotCompatibilityChecker compatibilityChecker;
    public FirstAvailableSpotStrategy(SpotCompatibilityChecker compatibilityChecker) {
        if (compatibilityChecker == null) {
            throw new IllegalArgumentException("SpotCompatibilityChecker cannot be null.");
        }
        this.compatibilityChecker = compatibilityChecker;
    }
    @Override
    public Optional<ParkingSpot> allocateSpot(ParkingLot parkingLot, Vehicle vehicle) {
        if (parkingLot == null) {
            throw new IllegalArgumentException("Parking lot cannot be null.");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        for (ParkingFloor floor : parkingLot.getParkingFloors().values()) {
            for (ParkingSpot spot : floor.getParkingSpots().values()) {
                if (spot.isAvailable() && compatibilityChecker.isCompatible(vehicle.getVehicleType(), spot.getSpotType())) {
                    return Optional.of(spot);
                }
            }
        }
        return Optional.empty();    
    }   

}
