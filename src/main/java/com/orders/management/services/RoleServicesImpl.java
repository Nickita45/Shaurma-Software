package com.orders.management.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.Role;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.repository.RoleRepository;
import com.orders.management.repository.ShaurmaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServicesImpl implements RoleServices{

    @Autowired
    private RoleRepository roleRepository;
    @Secured("ROLE_ADMIN")
    @Override
    public int removeRole(int id) {
        roleRepository.deleteById(id);
        return id;
    }
    @Secured("ROLE_ADMIN")
    @Override
    public List<Role> getAllRole() {
        return (List<Role>) roleRepository.findAll();
    }
    @Secured("ROLE_ADMIN")
    @Override
    public int addNewRole(Role role) {

        return  roleRepository.save(role).getId();
    }
    @Secured("ROLE_ADMIN")
    @Override
    public Role findbyId(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Set<Role> findByRoleIds(Set<Integer> roleIdList) {

            return roleRepository.findByRoleIds(roleIdList);
        }

}
