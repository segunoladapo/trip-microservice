package com.altimetrik.playground.threeoptionstrip.service;


import com.altimetrik.playground.threeoptionstrip.model.Search;
import com.altimetrik.playground.threeoptionstrip.model.hotel.Hotel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
import java.util.Comparator;
import java.util.List;

@Service
public class HotelService {
    @Value("${hotel.search.url}")
    private String HOTEL_SEARCH_URL;

    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    public List<Hotel> findHotels(Search search) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String searchUrl = String.format(HOTEL_SEARCH_URL, search.getDestinationCity(), search.getStartDate(),
                search.getEndDate(), "USD", API_KEY);
        String body = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, String.class).getBody();
        JSONObject jsonObj = new JSONObject(body);
        ObjectMapper mapper = new ObjectMapper();
        Hotel[] hotels = mapper.readValue(jsonObj.get("results").toString(), Hotel[].class);
        return Arrays.asList(hotels);
    }

    public Hotel findCheapest(List<Hotel> hotels) {
        return hotels.stream().
                min((a, b) -> Double.compare(a.getTotalPrice().getAmount(), b.getTotalPrice().getAmount())).get();
    }
}
