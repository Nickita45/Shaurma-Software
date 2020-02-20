package com.orders.management.resources;

import com.orders.management.domain.Spice;
import com.orders.management.services.SpiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spice")
public class SpiceController {
    @Autowired
    private SpiceServices serv;
    //@Secured({"USER"})

    @PreAuthorize("hasRole('ROLE__ADMIN')")
    @PutMapping
    public int addSpice(@RequestBody Spice adds) {
        return serv.addNewSpice(adds);
    }
  //  @Secured({"USER","ADMIN"})
    @PreAuthorize("hasAnyRole('ROLE__USER','ROLE__ADMIN')")
    @GetMapping
    public List<Spice> getAllSpices() {
        return serv.getAllSpices();
    }
    @DeleteMapping
    public int deleteSpice(@RequestParam int id) { return serv.removeSpice(id);}
}
