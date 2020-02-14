package com.orders.management.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.Role;
import com.orders.management.domain.ShaurmaType;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RoleServices {
    int removeRole(int id);
    List<Role> getAllRole();
    int addNewRole(Role role);
    Role findbyId(int id);
    Set<Role> findByRoleIds(Set<Integer> roleIdList);
}
