package com.demo.car_parking_management.serviceImpl;

import com.demo.car_parking_management.dao.CarDao;
import com.demo.car_parking_management.daoImpl.CarDaoImpl;
import com.demo.parking.entities.Car;
import com.demo.car_parking_management.service.Carservice;

import java.util.List;

public class CarserviceImpl implements Carservice {

    // Dependency on CarDao
    CarDao carDao = new CarDaoImpl();

    @Override
    public Car createCar(Car car) {
        return carDao.createCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public Car getCarByNumber(String carNumber) {
        return carDao.getCarByNumber(carNumber);
    }

    @Override
    public Car updateCar(String carNumber, Car updatedCar) {
        return carDao.updateCar(carNumber, updatedCar);
    }

    @Override
    public String deleteCarByNumber(String carNumber) {
        return carDao.deleteCarByNumber(carNumber);
    }
}
