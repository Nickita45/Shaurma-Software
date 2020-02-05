package com.orders.management.users.resources;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.orders.management.domain.User;
import com.orders.management.users.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class GreetingController {

    @Autowired
    private UserServices serv;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PutMapping
    public long AddPerson(@RequestBody User user) {
        return serv.addPerson(user);
    }

    @GetMapping
    public List<User> getAllPerson() {
        return serv.getAllPerson();
    }

    @DeleteMapping
    public void deletePerson(@RequestParam Long id){
        serv.deletePerson(id);
    }


}