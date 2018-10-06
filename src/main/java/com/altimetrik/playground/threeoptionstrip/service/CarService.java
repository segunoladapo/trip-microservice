package com.altimetrik.playground.threeoptionstrip.service;

import com.altimetrik.playground.threeoptionstrip.model.Search;
import com.altimetrik.playground.threeoptionstrip.model.car.AvailableCar;
import com.altimetrik.playground.threeoptionstrip.model.car.CarProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Value("${car.search.url}")
    private String CAR_SEARCH_RUL;

    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    public List<CarProvider> findCars(Search search) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String searchUrl = String.format(CAR_SEARCH_RUL, API_KEY, search.getDestinationCity(), search.getStartDate(),
                search.getEndDate());
        String body = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, String.class).getBody();
        JSONObject jsonObj = new JSONObject(body);
        ObjectMapper mapper = new ObjectMapper();
        CarProvider[] carProviders = mapper.readValue(jsonObj.get("results").toString(), CarProvider[].class);
        return Arrays.asList(carProviders);
    }

    public AvailableCar findCheapest(List<CarProvider> carProviders) {
        List<AvailableCar> cheapestAvailableCars = carProviders.stream()
                .map(carProvider -> carProvider.getAvailableCars().stream()
                        .min((a, b) -> Double.compare(a.getRates().get(0).getPrice().getAmount(),b.getRates().get(0).getPrice().getAmount())).get())
                .collect(Collectors.toList());
        AvailableCar cheapeastCar = cheapestAvailableCars
                .stream()
                .min((a, b) -> Double.compare(a.getRates().get(0).getPrice().getAmount(),b.getRates().get(0).getPrice().getAmount())).get();
        return cheapeastCar;
    }

}
