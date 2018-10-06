package com.altimetrik.playground.threeoptionstrip.model;

public class CarDto {

    public CarDto(Double price, String type){
        this.price = price;
        this.type = type;
    }

    private Double price;
    private String type;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
