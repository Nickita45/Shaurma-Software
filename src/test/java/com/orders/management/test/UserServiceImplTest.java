package com.orders.management.test;

import com.orders.management.domain.User;
import com.orders.management.users.repository.UserRepository;
import com.orders.management.users.resources.UserController;
import com.orders.management.users.services.UserServiceImpl;
import com.orders.management.users.services.UserServices;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Service;
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


    /*@Test
    void deleteUser() throws Exception{
        User user = new User();
        user.setId(1);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");
        //user.setRoleList();
    }
*/

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

        User result= userServiceImpl.getUser(id);
        assertNotNull(result);
        assertEquals(id,result.getId());

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        User res = userServiceImpl.getUser(id);
        assertNotNull(res);
        //assertEquals(id,res.getId());

    }
}