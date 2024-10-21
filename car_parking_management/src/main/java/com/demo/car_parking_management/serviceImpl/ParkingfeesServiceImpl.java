package com.demo.car_parking_management.serviceImpl;
import com.demo.car_parking_management.dao.ParkingFeesDao;
import com.demo.car_parking_management.daoImpl.ParkingFeesDaoImpl;
import com.demo.car_parking_management.service.ParkingFeesservice;
import com.demo.parking.entities.ParkingFees;

import java.util.List;

public class ParkingfeesServiceImpl implements ParkingFeesservice {

    // Dependency on ParkingFeesDao
    ParkingFeesDao parkingFeesDao = new ParkingFeesDaoImpl();

    @Override
    public ParkingFees createParkingFees(ParkingFees parkingFees) {
        return parkingFeesDao.createParkingFees(parkingFees);
    }

    @Override
    public List<ParkingFees> getAllParkingFees() {
        return parkingFeesDao.getAllParkingFees();
    }

    @Override
    public ParkingFees getParkingFeesById(String parkingFeesId) {
        return parkingFeesDao.getParkingFeesById(parkingFeesId);
    }

    @Override
    public ParkingFees updateParkingFees(String parkingFeesId, ParkingFees updatedParkingFees) {
        return parkingFeesDao.updateParkingFees(parkingFeesId, updatedParkingFees);
    }

    @Override
    public String deleteParkingFeesById(String parkingFeesId) {
        return parkingFeesDao.deleteParkingFeesById(parkingFeesId);
    }
}
