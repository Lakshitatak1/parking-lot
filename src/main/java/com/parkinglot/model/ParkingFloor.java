package com.parkinglot.model;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class ParkingFloor {
    private final int floorNumber;
    private Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber){
        if(floorNumber < 0){
            throw new IllegalArgumentException("Floor number cannot be negative.");
        }
        this.floorNumber = floorNumber;
        this.parkingSpots = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        if(parkingSpot == null){
            throw new IllegalArgumentException("Parking spot cannot be null.");
        }
        if(parkingSpots.containsKey(parkingSpot.getSpotId())){
            throw new IllegalArgumentException("Parking spot with this ID already exists.");
        }
        parkingSpots.put(parkingSpot.getSpotId(), parkingSpot);
    }

    public ParkingSpot getParkingSpot(String spotId){
        if(spotId == null || spotId.isEmpty()){
            throw new IllegalArgumentException("Spot ID cannot be null or empty.");
        }
        if(!parkingSpots.containsKey(spotId)){
            throw new IllegalArgumentException("Parking spot with this ID does not exist.");
        }
        return parkingSpots.get(spotId);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return Collections.unmodifiableMap(parkingSpots);
    }
}
