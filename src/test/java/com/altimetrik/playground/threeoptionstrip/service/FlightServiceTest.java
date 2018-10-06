package com.altimetrik.playground.threeoptionstrip.service;


import com.altimetrik.playground.threeoptionstrip.model.Search;
import com.altimetrik.playground.threeoptionstrip.model.air.Flight;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightServiceTest {

    @Test
    public void contextLoads() {
    }

    @TestConfiguration
    static class FlightServiceCOntextCOnfiguration {
        @Bean
        public AirService airService() {
            return new AirService();
        }
    }

    @Autowired
    private AirService airService;

    @Autowired
    private RestTemplate restTemplate;


    @Before
    public void setUp() throws IOException {
        Search search = new Search();
        search.setDestinationCity("BOS");
        search.setStartDate(("2018-12-07"));
        search.setEndDate(("2018-12-08"));
        search.setOriginationCity("LAX");
        //   Mockito.when(airService.FindFlights(search)).thenReturn(flights);

    }

    @Test
    public void givenAListOfFlights_ShouldReturnTheCheapest() throws IOException {
        List<Flight> flights = new ArrayList<>();
        Flight flight = new Flight();
        flight.setPrice(12.0);
        flight.setAirlineCode("B6");

        Flight flight2 = new Flight();
        flight2.setPrice(13.0);
        flight2.setAirlineCode("UA");

        Flight flight3 = new Flight();
        flight3.setPrice(14.0);
        flight3.setAirlineCode("JK");

        Flight flight4 = new Flight();
        flight4.setPrice(15.0);
        flight4.setAirlineCode("JB");

        flights.add(flight);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        Flight cheapestFlght = airService.findCheapest(flights);
        assertEquals(new Double(12.0), cheapestFlght.getPrice());
    }

}
