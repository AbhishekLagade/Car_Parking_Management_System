package com.demo.car_parking_management.daoImpl;



import com.demo.car_parking_management.dao.ParkingFeesDao;
import com.demo.parking.entities.ParkingFees;
import com.demo.car_parking_management.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class ParkingFeesDaoImpl implements ParkingFeesDao {

    public ParkingFees createParkingFees(ParkingFees parkingFees) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(parkingFees);
            session.getTransaction().commit();
            return parkingFees;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ParkingFees> getAllParkingFees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ParkingFees", ParkingFees.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ParkingFees getParkingFeesById(String parkingFeesId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ParkingFees.class, parkingFeesId);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ParkingFees updateParkingFees(String parkingFeesId, ParkingFees updatedParkingFees) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            ParkingFees existingParkingFees = session.get(ParkingFees.class, parkingFeesId);
            if (existingParkingFees != null) {
                // Update the fields
                existingParkingFees.setParkingFees_Type(updatedParkingFees.getParkingFees_Type());
                existingParkingFees.setParkingFees_Description(updatedParkingFees.getParkingFees_Description());
                existingParkingFees.setParkingFeesDate(updatedParkingFees.getParkingFeesDate());
                existingParkingFees.setParkingFeesAmount(updatedParkingFees.getParkingFeesAmount());
                session.update(existingParkingFees);
                session.getTransaction().commit();
                return existingParkingFees;
            }
            return null;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteParkingFeesById(String parkingFeesId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            ParkingFees parkingFees = session.get(ParkingFees.class, parkingFeesId);
            if (parkingFees != null) {
                session.delete(parkingFees);
                session.getTransaction().commit();
                return "ParkingFees deleted successfully.";
            } else {
                return "ParkingFees not found.";
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return "Failed to delete the parking fees.";
        }
    }
}

