package com.orders.management.resources;

import com.orders.management.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();


    @Test
    public void testAddUsers(){

        ResponseEntity<User> response = testRestTemplate.getForEntity("/users",User.class );

        /*User user = new User();
        int id = 1;
        user.setId(id);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");
        user.setRoleList();*/
    }
    @Test
    public void testGetUserById(){


    }


}