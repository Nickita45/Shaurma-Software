package com.orders.management.services;

import com.orders.management.domain.Role;
import com.orders.management.domain.User;
import com.orders.management.repository.UserRepository;
import com.orders.management.domain.DTOUser;
import com.orders.management.resources.RequestUser;
import com.orders.management.util.ObjectMapperUtils;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;


import java.util.Iterator;
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
    private ModelMapper modelMapper = new ModelMapper();


    //@Secured("ROLE_ADMIN")
    @Secured({ "ROLE_USER", "ROLE_ADMIN","ROLE_CASHIER"})
    @Override
    public List<DTOUser> getAllUsers() {

        List<DTOUser> user =  ObjectMapperUtils.mapAll((List<User>) userRep.findAll(), DTOUser.class);
        for(int i=0;i<user.size();i++)
        {
            Iterator<Role> iterator = ((List<User>) userRep.findAll()).get(i).getRoleList().iterator();
            String role_string = "";
            while (iterator.hasNext())
            role_string+="|"+iterator.next().getRoleName();
            role_string+="|";
            user.get(i).setUserIds(role_string);
        }
        return user;
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN","ROLE_CASHIER"})
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
    @Secured("ROLE_ADMIN")
    @Override
    public int deleteUser(int id) {
        userRep.deleteById(id);
        return id;
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN","ROLE_CASHIER"})
    @Override
    public User getUser(int id){
        Optional<User> optional = userRep.findById(id);
        return optional.orElse(new User());
    }
    @Secured("ROLE_ADMIN")
    @Override
    public User updateUser(User user){
        Optional<User> optional = userRep.findById(user.getId());
        if(optional.isPresent())
             return userRep.save(user);
        else return new User();
    }

    @Override
    public User authenticate(String login, String password) {
        return null;
    }

    @Override
    public Optional<User> findByLogin(String userName) {
        return userRep.findByLogin(userName);
    }
}
