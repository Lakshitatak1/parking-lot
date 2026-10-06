package com.parkinglot.fee;
import java.util.Map;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.ParkingTicket;

public class HourlyFeeCalculator implements FeeCalculator {
    private final Map<VehicleType, Long> hourlyRates;
    
    public HourlyFeeCalculator (){
        hourlyRates = Map.of(
            VehicleType.CAR, 4000L,
            VehicleType.MOTORCYCLE, 2000L,
            VehicleType.TRUCK, 6000L
        );
    }

    @Override
    public long calculateFee(ParkingTicket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Parking ticket cannot be null.");
        }
        long entryTime = ticket.getEntryTime();
        long exitTime = ticket.getExitTime();
        if (exitTime < entryTime) {
            throw new IllegalArgumentException("Exit time cannot be earlier than entry time.");
        }
        long durationMillis = exitTime - entryTime;
        long durationHours =  (durationMillis + (1000 * 60 * 60) - 1) / (1000 * 60 * 60); // Ceiling division
        if (durationHours == 0) {
            durationHours = 1; // Minimum charge for 1 hour
        }
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        Long ratePerHour = hourlyRates.get(vehicleType);
        if (ratePerHour == null) {
            throw new IllegalArgumentException("No rate defined for vehicle type: " + vehicleType);
        }
        return durationHours * ratePerHour;
    }
}
