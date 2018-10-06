package com.altimetrik.playground.threeoptionstrip.model;

public class HotelDto {

    public HotelDto(String line1, String city, String region, String postalCode, double totalPrice, String propertyName) {
        this.line1 = line1;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.totalPrice = totalPrice;
        this.propertyName = propertyName;
    }

    private String line1;
    private String city;
    private String region;
    private String postalCode;
    private double totalPrice;
    private String propertyName;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
