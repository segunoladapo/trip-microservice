package com.altimetrik.playground.threeoptionstrip.model.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CarProvider {
    @JsonProperty("cars")
    private List<AvailableCar> availableCars;
    private Location location;
    @JsonProperty("company_code")
    private String companyName;
    @JsonProperty("company_name")
    private String companyCode;



    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public List<AvailableCar> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(List<AvailableCar> availableCars) {
        this.availableCars = availableCars;
    }
}
