package com.orders.management.services;

import com.orders.management.domain.Spice;
import com.orders.management.domain.User;
import com.orders.management.repository.SpicesRepository;
import com.orders.management.repository.UserRepository;
import com.orders.management.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
class SpiceServiceImplTest {

    @InjectMocks
    private SpiceServiceImpl spiceService;

    @Mock
    private SpicesRepository spicesRepository;
    public void setSpice(Spice spice)
    {
        spice.setName("Chilly");
        spice.setPrice(new Random().nextInt(50));
    }
    @Test
    void removeSpice() {
        Spice sp1 = new Spice();
        setSpice(sp1);
        assertNotNull(sp1.getId());
        when(spicesRepository.save(sp1)).thenReturn(sp1);
        int result = spiceService.removeSpice(sp1.getId());
        assertNotNull(result);
        assertEquals(result, sp1.getId());
        System.out.println(sp1.getId() +""+ result);

        //when(spicesRepository.findById(0)).thenReturn(Optional.of(sp1));
        //when(spicesRepository.existsById(sp1.getId())).thenReturn(false);
        //assertFalse(spicesRepository.existsById(sp1.getId()));

    }

    @Test
    void getAllSpices() {
        Spice sp1 = new Spice();
        Spice sp2 = new Spice();

        setSpice(sp1);
        setSpice(sp2);
        List<Spice> spiceList = new ArrayList<>();
        spiceList.add(sp1);
        spiceList.add(sp2);
        //spiceList.add(sp1);
        when(spicesRepository.findAll()).thenReturn(spiceList);
       // spiceService.addNewSpice(sp1);
       // spiceService.addNewSpice(sp2);
        //Assert.assertThat(UserList,userServiceImpl.getAllUsers());
        List<Spice> result = spiceService.getAllSpices();
       // result.remove(sp2);
        assertNotNull(result);
        assertEquals(spiceList,result);
    }

    @Test
    void addNewSpice() {
        Spice sp1 = new Spice();
        setSpice(sp1);
        when(spicesRepository.save(sp1)).thenReturn(sp1);
        int result = spiceService.addNewSpice(sp1);
        assertNotNull(result);
        assertEquals(result, sp1.getId());
    }
}