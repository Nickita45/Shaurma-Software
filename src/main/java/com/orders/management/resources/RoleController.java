package com.orders.management.resources;

import com.orders.management.domain.Role;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.services.RoleServices;
import com.orders.management.services.ShaurmaTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServices roleServices;

    @PutMapping
    public int addRole(@RequestBody Role role) {
        return roleServices.addNewRole(role);
    }
    @GetMapping
    public List<Role> getAllSpices() {
        return roleServices.getAllRole();
    }
    @DeleteMapping
    public int deleteSpice(@RequestParam int id) { return roleServices.removeRole(id);}
}
