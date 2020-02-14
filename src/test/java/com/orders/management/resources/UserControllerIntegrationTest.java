package com.orders.management.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.orders.management.domain.User;
import com.orders.management.test.BaseIntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest extends BaseIntegrationTest {

    @LocalServerPort
    private int port;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void testAddUser() throws Exception{
        User user = new User();
        int id = 4;
        user.setId(id);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");

        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", getAuthorisationString());
        HttpEntity<User> entity = new HttpEntity<User>(user, header);
        ResponseEntity<String> userResponseEntity = testRestTemplate.exchange(
                createURLWithPort()+"/users", HttpMethod.PUT, entity ,String.class);
        //assertEquals(HttpStatus.OK, userResponseEntity.getStatusCode());
        //User resultUser = mapper.readValue(userResponseEntity.getBody(), User.class);
        //assertEquals(user, resultUser);
    }

    @Test
    public void testGetAllUSers() throws Exception {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Authorization",getAuthorisationString());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", header);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange
                (createURLWithPort() + "/users", HttpMethod.GET, entity, String.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void testUpdateUser(){

    }

    @Test
    public void testDeleteUser(){
        User user = new User();
        int id=1;
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", getAuthorisationString());
        HttpEntity<User> entity = new HttpEntity<User>(user, header);
        ResponseEntity<String> userResponseEntity = testRestTemplate.exchange(
                createURLWithPort()+ "/users/" + id, HttpMethod.DELETE, entity ,String.class);
    }

    private String createURLWithPort() {
        return "http://localhost:" + port ;
    }
}