package com.orders.management.services;

import com.orders.management.domain.User;
import com.orders.management.repository.UserRepository;
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
        Optional<User> optional = userRep.findById(id);
        return optional.orElse(new User());
    }

    @Override
    public User updateUser(User user){
        Optional<User> optional = userRep.findById(user.getId());
        if(optional.isPresent())
             return userRep.save(user);
        else return new User();
    }

    @Override
    public User authenticate(String login, String password) {
        return userRep.findByLoginAndPassword(login, password);
    }


}
