package com.orders.management.users.resources;

import com.orders.management.domain.Additive;
import com.orders.management.users.services.OrderLineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line")
public class AdditivesController {

    @Autowired
    private OrderLineServices serv;

    @PutMapping
    public int addAdditive(@RequestBody Additive adds) {
        return serv.addNewAdditive(adds);
    }
    @GetMapping
    public List<Additive> getAllAdditives() {
        return serv.getAllAdditives();
    }
    @DeleteMapping
    public int deleteAdditives(@RequestParam int id) { return serv.removeAdditive(id);}
}
