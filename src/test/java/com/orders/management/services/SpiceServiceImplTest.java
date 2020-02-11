package com.orders.management.services;

import com.orders.management.domain.Spice;
import com.orders.management.repository.SpicesRepository;
import com.orders.management.repository.UserRepository;
import com.orders.management.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class SpiceServiceImplTest {

    @InjectMocks
    private SpiceServiceImpl spiceService;

    @Mock
    private SpicesRepository spicesRepository;
    @Test
    void removeSpice() {
        Spice sp1 = new Spice();

    }

    @Test
    void getAllSpices() {
    }

    @Test
    void addNewSpice() {
    }
}