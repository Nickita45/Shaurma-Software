package com.orders.management.resources;

import com.orders.management.domain.ShaurmaType;
import com.orders.management.services.ShaurmaTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shaurma")
public class ShaurmaTypeController {
    @Autowired
    private ShaurmaTypeServices serv;

    @PutMapping
    public int addShaurmaType(@RequestBody ShaurmaType adds) {
        return serv.addNewShaurma(adds);
    }
    @GetMapping
    public List<ShaurmaType> getAllShaurmaType() {
        return serv.getAllShaurmaTypes();
    }
    @DeleteMapping
    public int deleteShaurmaType(@RequestParam int id) { return serv.removeShaurmaType(id);}
}
