package com.demo.car_parking_management.service;
import com.demo.parking.entities.ParkingFees;
import java.util.List;

public interface ParkingFeesservice {
    ParkingFees createParkingFees(ParkingFees parkingFees);
    List<ParkingFees> getAllParkingFees();
    ParkingFees getParkingFeesById(String parkingFeesId);
    ParkingFees updateParkingFees(String parkingFeesId, ParkingFees updatedParkingFees);
    String deleteParkingFeesById(String parkingFeesId);
}
