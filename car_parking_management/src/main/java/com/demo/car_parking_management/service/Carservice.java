package com.demo.car_parking_management.service;
import com.demo.parking.entities.Car;
import java.util.List;
public interface Carservice {
    Car createCar(Car car);
    List<Car> getAllCars();
    Car getCarByNumber(String carNumber);
    Car updateCar(String carNumber, Car updatedCar);
    String deleteCarByNumber(String carNumber);
}

