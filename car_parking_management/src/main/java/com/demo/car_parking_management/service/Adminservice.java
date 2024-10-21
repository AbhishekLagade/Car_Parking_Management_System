package com.demo.car_parking_management.service;
import com.demo.parking.entities.Admin;
import java.util.List;

public interface Adminservice {
    Admin createAdmin(Admin admin);
    Admin getAdminById(String adminId);
    List<Admin> getAllAdmins();
    Admin updateAdmin(String adminId,Admin admin);
    String deleteAdminById(String adminId);
}

