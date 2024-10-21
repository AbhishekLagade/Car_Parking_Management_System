package com.demo.car_parking_management.dao;

import com.demo.parking.entities.User;
import java.util.List;

public interface UserDao {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String userId);
    User updateUser(String userId, User updatedUser);
    String deleteUserById(String userId);
}
