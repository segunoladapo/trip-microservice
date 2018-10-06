package com.altimetrik.playground.threeoptionstrip.service;

import com.altimetrik.playground.threeoptionstrip.model.Search;
import com.altimetrik.playground.threeoptionstrip.model.air.Flight;
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

@Service
public class AirService {
    @Value("${flight.search.url}")
    private String FLIGHT_SEARCH_URL;

    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    public List<Flight> FindFlights(Search search) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String searchUrl = String.format(FLIGHT_SEARCH_URL, API_KEY, search.getOriginationCity(), search.getStartDate(),
                search.getEndDate(), search.getDestinationCity());
        String body = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, String.class).getBody();
        JSONObject jsonObj = new JSONObject(body);
        ObjectMapper mapper = new ObjectMapper();
        Flight[] flights = mapper.readValue(jsonObj.get("results").toString(), Flight[].class);
        return Arrays.asList(flights);
    }

    public Flight findCheapest(List<Flight> hotels) {
        return hotels.stream().
                min((a, b) -> Double.compare(a.getPrice(), b.getPrice())).get();
    }
}
