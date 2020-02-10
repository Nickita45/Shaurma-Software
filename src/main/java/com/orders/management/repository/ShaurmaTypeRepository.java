package com.orders.management.repository;

import com.orders.management.domain.ShaurmaType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShaurmaTypeRepository extends CrudRepository<ShaurmaType, Integer> {
}
