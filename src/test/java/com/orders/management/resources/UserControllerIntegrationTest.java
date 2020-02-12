package com.orders.management.resources;

import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.management.domain.User;
import com.orders.management.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.shaded.okhttp3.internal.http2.Header;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();


    /*protected HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
    }

    /*@BeforeEach
    public HttpHeaders httpHeaders(){
        headers = new HttpHeaders();
    }*/

    @Test
    public void testAddUsers() throws Exception{
        User user = new User();
        int id = 1;
        user.setId(id);
        user.setFirstName("Alex");
        user.setLastName("Petrov");
        user.setLogin("alex");
        user.setPassword("petrov");
        user.setActive(true);
        user.setEmail("alex@alex.com");

        String autorizationBase64 = HttpHeaders.encodeBasicAuth("user", "pass", StandardCharsets.UTF_8);

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Basic " + autorizationBase64);


        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        ResponseEntity<String> userResponseEntity = testRestTemplate.exchange(
                createURLWithPort()+"/users", HttpMethod.POST, entity ,String.class);
    }

    @Test
    public void testGetUserById() throws Exception {
       User user = new User();
        int id = 2;
        user.setId(id);
        user.setFirstName("Nick");
        user.setLastName("Povar");
        user.setLogin("nicky");
        user.setPassword("povar");
        user.setActive(false);
        user.setEmail("nick@alex.com");

        String autorizationBase64 = HttpHeaders.encodeBasicAuth("user", "pass", StandardCharsets.UTF_8);

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Basic " + autorizationBase64);


        HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange
                (createURLWithPort() + "/users",HttpMethod.GET,entity,String.class);
    }

    private String createURLWithPort() {
        return "http://localhost:" + port ;
    }

}