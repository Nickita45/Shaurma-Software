package com.orders.management.users.repository;

import com.orders.management.domain.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Document, Integer>{



}
