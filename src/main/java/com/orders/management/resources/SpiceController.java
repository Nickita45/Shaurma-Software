package com.orders.management.resources;

import com.orders.management.domain.Spice;
import com.orders.management.services.SpiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spice")
public class SpiceController {
    @Autowired
    private SpiceServices serv;

    @PutMapping
    public int addSpice(@RequestBody Spice adds) {
        return serv.addNewSpice(adds);
    }
    @GetMapping
    public List<Spice> getAllSpices() {
        return serv.getAllSpices();
    }
    @DeleteMapping
    public int deleteSpice(@RequestParam int id) { return serv.removeSpice(id);}
}
