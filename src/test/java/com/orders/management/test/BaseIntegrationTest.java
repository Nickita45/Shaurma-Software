package com.orders.management.test;

import com.orders.management.SpringBootAppIntegrationTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseIntegrationTest  {

    protected  Connection conn;

    @BeforeAll
    public void setUp() throws Exception{
        SpringBootAppIntegrationTest container = SpringBootAppIntegrationTest.getInstance();
        container.start();
        String login =  container.getUsername();
        String password = container.getPassword();
        String jdbcConnector = container.getJdbcUrl();
        conn = DriverManager.getConnection(jdbcConnector, login,password);
        //ResultSet resultSet = conn.createStatement().executeQuery(new String("select 1"));
    }

    @AfterAll
    public void drop() throws Exception{
        SpringBootAppIntegrationTest container = SpringBootAppIntegrationTest.getInstance();
        container.stop();
    }

    public String getAuthorisationString(){
        String autoBasicAuth = HttpHeaders.encodeBasicAuth("user", "pass", StandardCharsets.UTF_8);
        return String.format("Basic %s", autoBasicAuth);
    }

}
