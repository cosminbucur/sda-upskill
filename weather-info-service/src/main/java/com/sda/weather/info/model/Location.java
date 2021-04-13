package com.sda.weather.info.model;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "location_name")
    private String locationName;
    private Long latitude;
    private Long longitude;
    private String region;
    @Column(name = "country_name")
    private String countryName;

    public Location() {
    }

    public Location(String locationName, Long latitude, Long longitude, String region, String countryName) {
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.region = region;
        this.countryName = countryName;
    }
}
