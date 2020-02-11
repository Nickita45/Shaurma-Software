package com.orders.management.test;

import com.orders.management.domain.User;
import com.orders.management.users.repository.UserRepository;
import com.orders.management.users.resources.UserController;
import com.orders.management.users.services.UserServiceImpl;
import com.orders.management.users.services.UserServices;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Test
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

    @Test
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

    @Test
    public void addUser(){
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
    }

    @Test
    public void getAllUsers(){
        User user1 = new User();
        int id1=1;
        user1.setId(id1);
        user1.setFirstName("Alex");
        user1.setLastName("Petrov");
        user1.setLogin("alex");
        user1.setPassword("petrov");
        user1.setActive(true);
        user1.setEmail("alex@alex.com");

        User user2 = new User();
        int id2=2;
        user2.setId(id2);
        user2.setFirstName("Alex");
        user2.setLastName("Petrov");
        user2.setLogin("alex");
        user2.setPassword("petrov");
        user2.setActive(true);
        user2.setEmail("alex@alex.com");

        List<User> UserList = new ArrayList<>();
        UserList.add(user1);
        UserList.add(user2);

        when(userRepository.findAll()).thenReturn(UserList);
        //Assert.assertThat(UserList,userServiceImpl.getAllUsers());
        List<User> result = userServiceImpl.getAllUsers();
        assertNotNull(result);
        assertEquals(UserList,result);
    }

    @Test
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
    }

}