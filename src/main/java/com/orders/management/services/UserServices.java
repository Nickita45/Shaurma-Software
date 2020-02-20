package com.orders.management.services;

import com.orders.management.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    List<User> getAllUsers();
    int addUser(User user);
    int deleteUser(int id);
    User getUser(int id);
    User updateUser(User user);
    User authenticate(String login, String password);
}
