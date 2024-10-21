
package com.demo.car_parking_management.service;
//package com.demo.parking.service;

import com.demo.parking.entities.User;
import java.util.List;

public interface Userservice {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String userId);
    User updateUser(String userId, User updatedUser);
    String deleteUserById(String userId);
}
