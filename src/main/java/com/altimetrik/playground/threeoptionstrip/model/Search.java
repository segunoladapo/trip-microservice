package com.altimetrik.playground.threeoptionstrip.model;

import java.util.Date;

public class Search {
    private String originationCity;
    private String destinationCity;
    private String startDate;
    private String endDate;

    public String getOriginationCity() {
        return originationCity;
    }

    public void setOriginationCity(String originationCity) {
        this.originationCity = originationCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
