package com.orders.management.users.resources;


import com.orders.management.domain.Document;
import com.orders.management.users.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PutMapping
    public int addOrder(@RequestBody Document document){
        return orderService.addOrder(document);
    }

    @GetMapping
    public List<Document> getAllOrders(){
        return orderService.getAllOrders();
    }

    @DeleteMapping
    public void deleteOrder(@RequestParam Integer id){
        orderService.deleteOrder(id);
    }

    @PostMapping
    public Document update(@RequestBody Document document){
        return orderService.update(document);
    }

    @GetMapping("/id")
    public Document getOrderById(@RequestParam Integer id){
        return orderService.getOrderById(id);
    }
}
