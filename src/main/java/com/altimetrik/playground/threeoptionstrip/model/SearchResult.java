package com.altimetrik.playground.threeoptionstrip.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty("Flight")
    private FlightDto flightDto;
    @JsonProperty("CarProvider")
    private CarDto carDto;
    @JsonProperty("Hotel")
    private HotelDto hotelDto;

    public FlightDto getFlightDto() {
        return flightDto;
    }

    public void setFlightDto(FlightDto flightDto) {
        this.flightDto = flightDto;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public HotelDto getHotelDto() {
        return hotelDto;
    }

    public void setHotelDto(HotelDto hotelDto) {
        this.hotelDto = hotelDto;
    }
}
