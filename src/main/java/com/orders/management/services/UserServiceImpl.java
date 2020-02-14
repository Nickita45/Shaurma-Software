package com.orders.management.services;

import com.orders.management.domain.User;
import com.orders.management.repository.DocumentRepository;
import com.orders.management.repository.UserRepository;
import com.orders.management.resources.RequestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository userRep;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private LineServices lineServices;
    @Autowired
    private RoleServices roleServices;
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRep.findAll();
    }

    @Override
    public int addUser(RequestUser requestUser) {

        User user1 = new User();
        user1.setFirstName(requestUser.getFirstName());
        user1.setActive(requestUser.isActive());
        user1.setEmail(requestUser.getEmail());
        user1.setLastName(requestUser.getLastName());
        user1.setLogin(requestUser.getLogin());
        user1.setPassword(requestUser.getPassword());
        user1.setDocument(documentService.getDocumentById(requestUser.getDocumentId()));
        user1.setLine(lineServices.findbyId(requestUser.getLineId()));
        user1.setRoleList(roleServices.findByRoleIds(requestUser.getUserIds()));
        userRep.save(user1);
        return (int) user1.getId();
    }

    @Override
    public int deleteUser(int id) {
        userRep.deleteById(id);
        return id;
    }

    @Override
    public User getUser(int id){
        Optional<User> optional = userRep.findById(id);
        return optional.orElse(new User());
    }

    @Override
    public User updateUser(User user){
        Optional<User> optional = userRep.findById(user.getId());
        if(optional.isPresent())
             return userRep.save(user);
        else return new User();
    }

}
