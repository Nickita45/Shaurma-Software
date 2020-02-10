package com.orders.management.users.repository;

import com.orders.management.domain.Line;
import com.orders.management.domain.ShaurmaType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends CrudRepository<Line, Integer> {


}
