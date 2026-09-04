package com.parkinglot.model;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
public class ParkingLot {
    private final String lotId;
    private final Map<Integer, ParkingFloor> parkingFloors;

    public ParkingLot(String lotId) {
        if(lotId == null || lotId.isEmpty()) {
            throw new IllegalArgumentException("Lot ID cannot be null or empty.");
        }
        this.lotId = lotId;
        this.parkingFloors = new TreeMap<>();
    }

    public void addParkingFloor(ParkingFloor parkingFloor){
        if(parkingFloor == null){
            throw new IllegalArgumentException("Parking floor cannot be null.");
        }

        if(parkingFloors.containsKey(parkingFloor.getFloorNumber())){
            throw new IllegalArgumentException("Parking floor with this number already exists.");
        }
        parkingFloors.put(parkingFloor.getFloorNumber(), parkingFloor);
    }
   
    public ParkingFloor getParkingFloor(int floorNumber){
        if(!parkingFloors.containsKey(floorNumber)){
            throw new IllegalArgumentException("Parking floor with this number does not exist.");
        }
        return parkingFloors.get(floorNumber);
    }

    public Map<Integer, ParkingFloor> getParkingFloors() {
        return Collections.unmodifiableMap(parkingFloors);
    }
    public String getLotId() {
        return lotId;
    }

}
