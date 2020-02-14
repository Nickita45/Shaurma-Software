package com.orders.management.resources;

import java.lang.reflect.Type;
import java.util.List;

import com.orders.management.domain.User;
import com.orders.management.services.UserServices;
import com.orders.management.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        List<DTOUser> user = ObjectMapperUtils.mapAll(serv.getAllUsers(), DTOUser.class);
        return user;
    }

    @DeleteMapping
    public void deleteUser(@RequestParam int id){
        serv.deleteUser(id);
    }

    @GetMapping("/id")
    public User getUser(@RequestParam int id) { return serv.getUser(id); }

    @PostMapping
    public User updateUser(@RequestBody User user){ return serv.updateUser(user); }
    private DTOUser convertToDto(User post) {
        DTOUser postDto = modelMapper.map(post, DTOUser.class);

        return postDto;
    }

}
