package com.orders.management.users.repository;


import com.orders.management.domain.Additive;
import com.orders.management.domain.Line;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AdditivesRepository extends CrudRepository<Additive, Integer> {

    @Query( value = "select * from additive where id IN :ids" , nativeQuery = true)
    Set<Additive> findByAdditiveIds(@Param("ids") Set<Integer> additiveIdList);
}
