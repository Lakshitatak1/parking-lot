package com.parkinglot.strategy;
import java.util.Map;
import java.util.Set;

import com.parkinglot.enums.SpotType;
import com.parkinglot.enums.VehicleType;
public class SpotCompatibilityChecker {
    private final Map<VehicleType,Set<SpotType>> compatibilityMap;
    public SpotCompatibilityChecker(){
        this.compatibilityMap = Map.of(
            VehicleType.MOTORCYCLE, Set.of(SpotType.COMPACT, SpotType.LARGE, SpotType.MOTORCYCLE),
            VehicleType.CAR, Set.of(SpotType.COMPACT, SpotType.LARGE),
            VehicleType.TRUCK, Set.of(SpotType.LARGE)
        );
    }

    public boolean isCompatible(VehicleType vehicleType, SpotType spotType){
        Set<SpotType> compatibleSpots = compatibilityMap.get(vehicleType);
        return compatibleSpots != null && compatibleSpots.contains(spotType);
    }
}
