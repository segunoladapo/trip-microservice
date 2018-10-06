package com.altimetrik.playground.threeoptionstrip.service;


import com.altimetrik.playground.threeoptionstrip.model.car.AvailableCar;
import com.altimetrik.playground.threeoptionstrip.model.car.CarProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarProviderServiceTest {

    @Test
    public void contextLoads() {
    }
    @TestConfiguration
    static class CarServiceCOntextCOnfiguration {
        @Bean
        public CarService carService() {
            return new CarService();
        }
    }


    @Before
    public void setUp() throws IOException {
    }


    @Test
    public void givenAListOfCarsAvailableForRental_ShouldReturnTheCheapestOne() {
        CarProvider carProvider1 = new CarProvider();
        List<AvailableCar> cars = new ArrayList<>();
      //  AvailableCar availableCar1 = new AvailableCar();
      //  availableCar1.se
      //  carProvider.setAvailableCars();
    }

}
