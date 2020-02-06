package com.orders.management.users.services;

        import com.orders.management.domain.Order;
        import com.orders.management.users.repository.OrderRepository;
        import org.springframework.stereotype.Service;

        import java.util.Date;
        import java.util.List;
        import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService{

    private OrderRepository orderRepository;

    @Override
    public int addOrder(Order order) {
        return orderRepository.save(order).getId();
    }

    @Override
    public void update(Order order) {
        if(order.getId() != null){
            orderRepository.save(order);
            Date date = new Date();
            order.setDate(date);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
