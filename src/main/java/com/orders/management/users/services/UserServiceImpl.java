package com.orders.management.users.services;

import com.orders.management.domain.User;
import com.orders.management.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository userRep;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRep.findAll();
    }

    @Override
    public int addUser(User user) {
        userRep.save(user);
        return (int) user.getId();
    }

    @Override
    public int deleteUser(int id) {
        userRep.deleteById(id);
        return id;
    }

    @Override
    public User getUser(int id){
        userRep.findById(id);
    })

}
