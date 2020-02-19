package com.orders.management.repository;

import com.orders.management.domain.Additive;
import com.orders.management.domain.Role;
import com.orders.management.domain.ShaurmaType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    @Query( value = "select * from role_table where id IN :ids" , nativeQuery = true)
    Set<Role> findByRoleIds(@Param("ids") Set<Integer> roleIdList);


}
