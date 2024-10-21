package com.demo.car_parking_management.daoImpl;
import com.demo.car_parking_management.dao.CarDao;
import com.demo.parking.entities.Car;
import com.demo.car_parking_management.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CarDaoImpl implements CarDao {

    @Override
    public Car createCar(Car car) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
            return car;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Car> getAllCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car", Car.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Car getCarByNumber(String carNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Car.class, carNumber);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Car updateCar(String carNumber, Car updatedCar) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Car existingCar = session.get(Car.class, carNumber);
            if (existingCar != null) {
                // Update relevant fields
                existingCar.setCar_Type(updatedCar.getCar_Type());
                existingCar.setCar_Description(updatedCar.getCar_Description());
                existingCar.setCar_Category(updatedCar.getCar_Category());
                session.update(existingCar);
                session.getTransaction().commit();
                return existingCar;
            }
            return null;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteCarByNumber(String carNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, carNumber);
            if (car != null) {
                session.delete(car);
                session.getTransaction().commit();
                return "Car deleted successfully.";
            } else {
                return "Car not found.";
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return "Failed to delete the car.";
        }
    }
}

