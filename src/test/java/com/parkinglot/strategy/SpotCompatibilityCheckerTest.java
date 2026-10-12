package com.parkinglot.strategy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.parkinglot.enums.SpotType;
import com.parkinglot.enums.VehicleType;

public class SpotCompatibilityCheckerTest {
    @Test
    void carShouldBeCompatibleWithCompactSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();

        boolean result = checker.isCompatible(VehicleType.CAR, SpotType.COMPACT);

        assertTrue(result);
    }

    @Test
    void motorcycleShouldBeCompatibleWithMotorcycleSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();  
        boolean result = checker.isCompatible(VehicleType.MOTORCYCLE, SpotType.MOTORCYCLE);
        assertTrue(result);
    }

    @Test
    void truckShouldBeCompatibleWithLargeSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();
        boolean result = checker.isCompatible(VehicleType.TRUCK, SpotType.LARGE);
        assertTrue(result);
    }

    @Test
    void motorcycleShouldBeCompatibleWithLargeSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();
        boolean result = checker.isCompatible(VehicleType.MOTORCYCLE, SpotType.LARGE);
        assertTrue(result);
    }

    @Test
    void carShouldBeCompatibleWithLargeSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();
        boolean result = checker.isCompatible(VehicleType.CAR, SpotType.LARGE);
        assertTrue(result);
    }

    @Test
    void motorcycleShouldBeCompatibleWithCompactSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();
        boolean result = checker.isCompatible(VehicleType.MOTORCYCLE, SpotType.COMPACT);
        assertTrue(result);
    }

    @Test
    void truckShouldNotBeCompatibleWithCompactSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();
        boolean result = checker.isCompatible(VehicleType.TRUCK, SpotType.COMPACT);
        assertFalse(result);
    }

    @Test
    void truckShouldNotBeCompatibleWithMotorcycleSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();
        boolean result = checker.isCompatible(VehicleType.TRUCK, SpotType.MOTORCYCLE);
        assertFalse(result);
    }

    @Test
    void carShouldNotBeCompatibleWithMotorcycleSpot() {
        SpotCompatibilityChecker checker = new SpotCompatibilityChecker();
        boolean result = checker.isCompatible(VehicleType.CAR, SpotType.MOTORCYCLE);
        assertFalse(result);
    }
}
