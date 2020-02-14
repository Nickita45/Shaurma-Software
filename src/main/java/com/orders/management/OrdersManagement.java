package com.orders.management;

import com.orders.management.domain.Role;
import com.orders.management.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrdersManagement {

	public static void main(String[] args) {
		SpringApplication.run(OrdersManagement.class, args);

	}

}
