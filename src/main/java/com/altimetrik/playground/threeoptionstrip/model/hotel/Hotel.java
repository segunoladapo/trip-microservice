package com.altimetrik.playground.threeoptionstrip.model.hotel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Hotel {
    private Location location;
    @JsonProperty("total_price")
    private TotalPrice totalPrice;
    private Address address;
    private String propertyName;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(TotalPrice totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
