package com.orders.management.users.resources;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.orders.management.domain.User;
import com.orders.management.users.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices serv;

    @PutMapping
    public int AddUser(@RequestBody User user) {
        return serv.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return serv.getAllUsers();
    }

    @DeleteMapping
    public void deleteUser(@RequestParam int id){
        serv.deleteUser(id);
    }

}
