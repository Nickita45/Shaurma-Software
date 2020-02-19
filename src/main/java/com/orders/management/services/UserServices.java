package com.orders.management.services;

import com.orders.management.domain.User;
import com.orders.management.domain.DTOUser;
import com.orders.management.resources.RequestUser;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    List<DTOUser> getAllUsers();
    int addUser(RequestUser requestUser);
    int deleteUser(int id);
    User getUser(int id);
    User updateUser(User user);
    Optional<User> findByLogin(String userName);
}
