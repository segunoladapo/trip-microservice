package com.altimetrik.playground.threeoptionstrip.model.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Rate {
    private String type;
    private Price price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
