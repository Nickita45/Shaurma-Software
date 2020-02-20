package com.orders.management.test;

import com.orders.management.domain.DTOUser;
import com.orders.management.domain.User;
import com.orders.management.repository.UserRepository;
import com.orders.management.resources.RequestUser;
import com.orders.management.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Test // not ready / doesnt work
    public void deleteUser(){
        User user = new User();
        int id=1;
        user.setId(id);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");
        //user.setRoleList("User");

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userRepository.existsById(user.getId())).thenReturn(false);
        assertFalse(userRepository.existsById(user.getId()));



    }

    @Test // ready
    public void getUser(){
        User user = new User();
        int id=1;
        user.setId(id);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");


        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        User result= userServiceImpl.getUser(id); // get info about user
        assertNotNull(result);
        assertEquals(id,result.getId());

        when(userRepository.findById(id)).thenReturn(Optional.empty()); // user -- null
        User res = userServiceImpl.getUser(id);
        assertNotNull(res);
    }

    @Test // not ready / doesnt work
    public void addUser(){
        RequestUser user = new RequestUser();

        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");
        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(1);
        set1.add(2);
        user.setUserIds(set1);

       // when(userRepository.save(user)).thenReturn(user);
       // int result = userServiceImpl.addUser(user);
        //assertNotNull(result);
        //assertEquals(result, user.getId());


    }

    @Test //ready?
    public void getAllUsers(){
        DTOUser user1 = new DTOUser();
       // int id1=1;
       // user1.setId(id1);
        user1.setFirstName("Alex");
        user1.setLastName("Petrov");
        user1.setLogin("alex");
       // user1.setPassword("petrov");
        user1.setActive(true);
        user1.setEmail("alex@alex.com");

        DTOUser user2 = new DTOUser();
       // int id2=2;
       // user2.setId(id2);
        user2.setFirstName("Alex");
        user2.setLastName("Petrov");
        user2.setLogin("alex");
    //    user2.setPassword("petrov");
        user2.setActive(true);
        user2.setEmail("alex@alex.com");

        List<DTOUser> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

       // when(userRepository.findAll()).thenReturn(userList);
        //Assert.assertThat(UserList,userServiceImpl.getAllUsers());
       // List<DTOUser> result = userServiceImpl.getAllUsers();
       // assertNotNull(result);
//        assertEquals(userList,result);
    }

    @Test // not ready / doent work
    public void updateUser(){
        User user = new User();
        int id=1;
        user.setId(id);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User result = userServiceImpl.updateUser(user);
        assertEquals(user,result);
    }

}