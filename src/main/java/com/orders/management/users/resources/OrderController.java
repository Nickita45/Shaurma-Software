package com.orders.management.users.resources;


import com.orders.management.domain.Order;
import com.orders.management.users.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PutMapping
    public int addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @DeleteMapping
    public void deleteOrder(@RequestParam Integer id){
        orderService.deleteOrder(id);
    }

    public void update(@RequestBody Order order){
        orderService.update(order);
    }

    public Optional<Order> getOrderById(Integer id){
        return orderService.getOrderById(id);
    }
}
