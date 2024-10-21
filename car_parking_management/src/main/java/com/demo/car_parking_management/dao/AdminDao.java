package com.demo.car_parking_management.dao;
import com.demo.parking.entities.Admin;
import java.util.List;

public interface AdminDao {
    Admin createAdmin(Admin admin);
    Admin getAdminById(String adminId);
    List<Admin> getAllAdmins();
    Admin updateAdmin(String adminId, Admin admin);
    String deleteAdminById(String adminId);
}
