package com.orders.management.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.orders.management.SpringBootAppIntegrationTest;
import com.orders.management.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Logger;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    public HttpHeaders gethttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        String autorizationBase64 = HttpHeaders.encodeBasicAuth(
                "user", "pass", StandardCharsets.UTF_8);
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Basic " + autorizationBase64);
        return headers;
    }

    @Test
    public void testAddUser() throws Exception{
        SpringBootAppIntegrationTest container = SpringBootAppIntegrationTest.getInstance();
        container.start();
        String login =  container.getUsername();
        String password = container.getPassword();
        String jdbcConnector = container.getJdbcUrl();
        Connection conn = DriverManager.getConnection(jdbcConnector, login,password);
        ResultSet resultSet = conn.createStatement().executeQuery(new String("select 1"));
        container.stop();
        User user = new User();
        int id = 1;
        user.setId(id);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");

        HttpEntity<User> entity = new HttpEntity<User>(user, gethttpHeaders());
        ResponseEntity<String> userResponseEntity = testRestTemplate.exchange(
                createURLWithPort()+"/users", HttpMethod.PUT, entity ,String.class);

        //assertEquals(HttpStatus.OK, userResponseEntity.getStatusCode());
        //User resultUser = mapper.readValue(userResponseEntity.getBody(), User.class);
        //assertEquals(user, resultUser);
    }

    @Test
    public void testGetAllUSers() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>("parameters", gethttpHeaders());
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
        int id=2;
        HttpEntity<User> entity = new HttpEntity<User>(user, gethttpHeaders());
        ResponseEntity<String> userResponseEntity = testRestTemplate.exchange(
                createURLWithPort()+ "/users/" + id, HttpMethod.DELETE, entity ,String.class);
    }

    private String createURLWithPort() {
        return "http://localhost:" + port ;
    }

}