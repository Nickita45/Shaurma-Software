package com.orders.management.users.services;

        import com.orders.management.domain.Order;
        import com.orders.management.users.repository.OrderRepository;
        import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService{

    private OrderRepository orderRepository;

    @Override
    public int addOrder(Order order) {
        orderRepository.save(order);
        return order.getId();
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
