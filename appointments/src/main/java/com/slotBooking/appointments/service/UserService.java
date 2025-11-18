package com.slotBooking.appointments.service;

import com.slotBooking.appointments.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);
}
