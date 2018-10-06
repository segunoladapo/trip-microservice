package com.altimetrik.playground.threeoptionstrip.controller;

import com.altimetrik.playground.threeoptionstrip.model.*;
import com.altimetrik.playground.threeoptionstrip.model.air.Flight;
import com.altimetrik.playground.threeoptionstrip.model.car.AvailableCar;
import com.altimetrik.playground.threeoptionstrip.model.car.CarProvider;
import com.altimetrik.playground.threeoptionstrip.model.hotel.Hotel;
import com.altimetrik.playground.threeoptionstrip.service.AirService;
import com.altimetrik.playground.threeoptionstrip.service.CarService;
import com.altimetrik.playground.threeoptionstrip.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/v1/trip")
public class TripController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private AirService airService;

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<?> findTripOptions(@RequestParam String origin, @RequestParam String destination,
                                             @RequestParam String startDate, @RequestParam String endDate) throws Exception {
        Search search = new Search();
        /*
        search.setDestinationCity("BOS");
        search.setStartDate(("2018-12-07"));
        search.setEndDate(("2018-12-08"));
        search.setOriginationCity("LAX");
        */
        search.setDestinationCity(destination);
        search.setOriginationCity(origin);
        search.setEndDate(endDate);
        search.setStartDate(startDate);

        List<Hotel> hotels = hotelService.findHotels(search);

        List<Flight> flights = airService.FindFlights(search);

//        List<CarProvider> carProviders = carService.findCars(search);

        HashMap<String, SearchResult> results = new HashMap<>();

        Hotel cheapestHotel = hotelService.findCheapest(hotels);

  //      AvailableCar cheapestCar = carService.findCheapest(carProviders);

        Flight cheapestFlight = airService.findCheapest(flights);

        SearchResult cheapestSearchResult = new SearchResult();
  //      cheapestSearchResult.setCarDto(new CarDto(cheapestCar.getRates().get(0).getPrice().getAmount(), cheapestCar.getRates().get(0).getType()));
        cheapestSearchResult.setFlightDto(new FlightDto(cheapestFlight.getAirlineCode(), cheapestFlight.getPrice()));
        cheapestSearchResult.setHotelDto(new HotelDto(cheapestHotel.getAddress().getLine1(),
                cheapestHotel.getAddress().getCity(), cheapestHotel.getAddress().getRegion(),
                cheapestHotel.getAddress().getPostalCode(), cheapestHotel.getTotalPrice().getAmount(), cheapestHotel.getPropertyName()));
        results.put("cheapest", cheapestSearchResult);

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

}
