package com.demo.car_parking_management.serviceImpl;

import com.demo.car_parking_management.dao.AdminDao;
import com.demo.car_parking_management.daoImpl.AdminDaoImpl;
import com.demo.parking.entities.Admin;
import com.demo.car_parking_management.service.Adminservice;

import java.util.List;

public class AdminserviceImpl implements Adminservice {

    // Dependency on AdminDao
    AdminDao adminDao = (AdminDao) new AdminDaoImpl ();

    @Override
    public Admin createAdmin(Admin admin) {
        return adminDao.createAdmin(admin);
    }

    @Override
    public Admin getAdminById(String adminId) {
        return adminDao.getAdminById(adminId);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }

    @Override
    public Admin updateAdmin(String adminId, Admin updatedAdmin) {
        return adminDao.updateAdmin(adminId, updatedAdmin);
    }

    @Override
    public String  deleteAdminById(String adminId) {
        return adminDao.deleteAdminById(adminId);
    }
}



