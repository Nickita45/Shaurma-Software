package com.orders.management.services;

import com.orders.management.domain.Additive;
import com.orders.management.domain.Role;
import com.orders.management.domain.ShaurmaType;
import com.orders.management.repository.RoleRepository;
import com.orders.management.repository.ShaurmaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServicesImpl implements RoleServices{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public int removeRole(int id) {
        roleRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Role> getAllRole() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public int addNewRole(Role role) {

        return  roleRepository.save(role).getId();
    }

    @Override
    public Role findbyId(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Set<Role> findByRoleIds(Set<Integer> roleIdList) {

            return roleRepository.findByRoleIds(roleIdList);
        }

}
