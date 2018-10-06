package com.altimetrik.playground.threeoptionstrip.model;

public class FlightDto {

    public FlightDto(String airline, double price){
        this.airline = airline;
        this.price = price;
    }
    private String airline;
    private double price;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
