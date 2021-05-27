package com.sda.weather.info.service;

import com.sda.weather.info.dto.LocationRequest;
import com.sda.weather.info.model.Location;
import com.sda.weather.info.model.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final LocationRepository locationRepository;

    @Autowired
    public WeatherService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location saveLocation(LocationRequest request) {
        Location location = new Location(
                request.getLocationName(),
                request.getLatitude(),
                request.getLongitude(),
                request.getRegion(),
                request.getCountryName()
        );

        return locationRepository.save(location);
    }

    public Location findByLocationName(String locationName) {
        return locationRepository.findByLocationName(locationName);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location updateLocation(Long id, LocationRequest request) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("location not found"));

        location.setLocationName(request.getLocationName());
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        location.setRegion(request.getRegion());
        location.setCountryName(request.getCountryName());

        return locationRepository.save(location);
    }
}
