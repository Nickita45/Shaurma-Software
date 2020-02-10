package com.orders.management.users.resources;

import com.orders.management.domain.ShaurmaType;
import com.orders.management.domain.Spice;
import com.orders.management.users.services.ShaurmaTypeServices;
import com.orders.management.users.services.SpiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shaurma")
public class ShaurmaTypeController {
    @Autowired
    private ShaurmaTypeServices serv;

    @PutMapping
    public int addASpice(@RequestBody ShaurmaType adds) {
        return serv.addNewShaurma(adds);
    }
    @GetMapping
    public List<ShaurmaType> getAllSpices() {
        return serv.getAllShaurmaTypes();
    }
    @DeleteMapping
    public int deleteSpice(@RequestParam int id) { return serv.removeShaurmaType(id);}
}
