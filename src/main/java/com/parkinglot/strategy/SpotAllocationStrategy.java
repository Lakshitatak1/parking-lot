package com.parkinglot.strategy;
import java.util.Optional;

import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;
public interface SpotAllocationStrategy {

    Optional<ParkingSpot> allocateSpot(ParkingLot parkingLot, Vehicle vehicle);

}
