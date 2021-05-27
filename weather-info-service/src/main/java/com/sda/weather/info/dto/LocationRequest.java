package com.sda.weather.info.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Validated
public class LocationRequest {

    @NotEmpty(message = "location name should not be empty")
    private String locationName;

    @Min(value = -90, message = "min latitude -90")
    @Max(value = 90, message = "max latitude 90")
    private Double latitude;

    @Min(value = -180, message = "min longitude -180")
    @Max(value = 180, message = "max longitude 180")
    private Double longitude;

    private String region;

    @NotEmpty(message = "country name should not be empty")
    private String countryName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
