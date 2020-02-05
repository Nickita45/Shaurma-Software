package com.orders.management.users.services;

import com.orders.management.domain.User;

import java.util.List;

public interface UserServices {
    List<User> getAllPerson();
    long addPerson(User pers);
    void deletePerson(long id);
}
