package com.orders.management.resources;

import java.awt.*;
import java.util.List;

import com.orders.management.domain.DTOUser;
import com.orders.management.domain.User;
import com.orders.management.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices serv;

    private ModelMapper modelMapper = new ModelMapper();

    @PutMapping
    public int AddUser(@RequestBody RequestUser user) {
        return serv.addUser(user);
    }


    @GetMapping
    public List<DTOUser> getAllUsers() {

        //List<DTOUser> user = ObjectMapperUtils.mapAll(serv.getAllUsers(), DTOUser.class);
        return serv.getAllUsers();
    }

    @DeleteMapping("/id")
    public void deleteUser(@RequestParam int id){
        serv.deleteUser(id);
    }

    @GetMapping("/id")
    public User getUser(@RequestParam int id) { return serv.getUser(id); }

    @PostMapping
    public User updateUser(@RequestBody User user){ return serv.updateUser(user); }

    @PostMapping("/authenticate")
    public User authenticate(@RequestBody String login, String password){ return serv.authenticate(login,password); }


}
