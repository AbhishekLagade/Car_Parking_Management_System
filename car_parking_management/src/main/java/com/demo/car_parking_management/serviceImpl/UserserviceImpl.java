package com.demo.car_parking_management.serviceImpl;

//package com.demo.parking.service.impl;

import com.demo.car_parking_management.dao.UserDao;
import com.demo.car_parking_management.daoImpl.UserDaoImpl;
import com.demo.parking.entities.User;
import com.demo.car_parking_management.service.Userservice;

import java.util.List;

public class UserserviceImpl implements Userservice {

    // Dependency on UserDao
    UserDao userDao = new UserDaoImpl();

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User updateUser(String userId, User updatedUser) {
        return userDao.updateUser(userId, updatedUser);
    }

    @Override
    public String deleteUserById(String userId) {
        return userDao.deleteUserById(userId);
    }
}
