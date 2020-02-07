package com.orders.management.test;

import com.orders.management.users.resources.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)

public class OrdersManagementTest {
    @Test
    public void contextLoads() {
    }
}