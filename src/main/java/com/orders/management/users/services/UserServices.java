package com.orders.management.users.services;

import com.orders.management.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    List<User> getAllUsers();
    int addUser(User user);
    int deleteUser(int id);
}
