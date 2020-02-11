package com.orders.management.repository;

import com.orders.management.domain.Spice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SpicesRepository extends CrudRepository<Spice, Integer> {

    @Query( value = "select * from spice where id IN :ids" , nativeQuery = true)
    Set<Spice> findBySpiceIds(@Param("ids") Set<Integer> spiceIdList);

}
