package com.orders.management.users.resources;

import com.orders.management.domain.Additive;
import com.orders.management.users.services.OrderLineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line")
public class OrderLineController {

    @Autowired
    private OrderLineServices serv;

    @PutMapping
    public long addAdditive(@RequestBody Additive adds) {
        return serv.addNewAdditive(adds);
    }
    @GetMapping
    public List<Additive> getAllAdditives() {
        return serv.getAllAdditives();
    }
}
