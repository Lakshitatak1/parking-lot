package com.parkinglot.fee;
import com.parkinglot.model.ParkingTicket;
public interface FeeCalculator {
    long calculateFee(ParkingTicket ticket);
}
