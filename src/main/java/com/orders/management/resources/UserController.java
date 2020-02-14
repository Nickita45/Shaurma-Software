package com.orders.management.resources;

import java.util.List;

import com.orders.management.domain.User;
import com.orders.management.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices serv;

    @PutMapping
    public int AddUser(@RequestBody RequestUser user) {
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

    @GetMapping("/id")
    public User getUser(@RequestParam int id) { return serv.getUser(id); }

    @PostMapping
    public User updateUser(@RequestBody User user){ return serv.updateUser(user); }


}
