package com.orders.management.users.repository;


import com.orders.management.domain.OrderLine;
import com.orders.management.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {

}
