package com.orders.management.users.repository;


import com.orders.management.domain.Additive;
import com.orders.management.domain.Line;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<Additive, Integer> {

}
