package com.orders.management.users.services;

import com.orders.management.domain.User;
import com.orders.management.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserserviceImpl implements UserServices{
   @Autowired
   private UserRepository person;
    @Override
    public List<User> getAllPerson(){

        return (List<User>) person.findAll();
    }

    @Override
    public long addPerson(User pers){
        person.save(pers);
        return pers.getId();
    }

    @Override
    public void deletePerson(long id){
        person.deleteById(id);
    }
}
