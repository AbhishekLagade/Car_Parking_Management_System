package com.demo.car_parking_management.daoImpl;

import com.demo.parking.entities.Admin;
import com.demo.car_parking_management.HibernateUtil;
import com.demo.car_parking_management.dao.AdminDao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    public Admin createAdmin(Admin admin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(admin);
            session.getTransaction().commit();
            return admin;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Admin> getAllAdmins() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Admin", Admin.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Admin getAdminById(String adminId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Admin.class, adminId);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Admin updateAdmin(String adminId, Admin updatedAdmin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Admin existingAdmin = session.get(Admin.class, adminId);
            if (existingAdmin != null) {
                // Update relevant fields
                existingAdmin.setParkingFees_Type(updatedAdmin.getParkingFees_Type());
                existingAdmin.setPer_Module(updatedAdmin.getPer_Module());
                existingAdmin.setDate(updatedAdmin.getDate());
                session.update(existingAdmin);
                session.getTransaction().commit();
                return existingAdmin;
            }
            return null;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String deleteAdminById(String adminId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Admin admin = session.get(Admin.class, adminId);
            if (admin != null) {
                session.delete(admin);
                session.getTransaction().commit();
                return "Admin deleted successfully.";
            } else {
                return "Admin not found.";
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return "Failed to delete the admin.";
        }
    }
}
