package com.sda.weather.info.controller;

import com.sda.weather.info.dto.LocationRequest;
import com.sda.weather.info.model.Location;
import com.sda.weather.info.openweather.OpenWeatherResponse;
import com.sda.weather.info.service.WeatherService;
import com.sda.weather.info.weatherstack.WeatherStackResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/weather")
@RestController
public class WeatherResource {

    private static final Logger log = LoggerFactory.getLogger(WeatherResource.class);
    private static final String OPEN_WEATHER_API = "http://api.openweathermap.org/data/2.5/";
    private static final String OPEN_WEATHER_API_KEY = "bc3d654cabcea5227406acdf1d502154";

    private static final String WEATHER_STACK_API = "http://api.weatherstack.com/";
    private static final String WEATHER_STACK_API_KEY = "3f4930f840181ae139b5c17037376f2c";

    private final RestTemplate restTemplate;
    private final WeatherService weatherService;

    @Autowired
    public WeatherResource(RestTemplate restTemplate, WeatherService weatherService) {
        this.restTemplate = restTemplate;
        this.weatherService = weatherService;
    }

    // fetch weather values
    @GetMapping("weather-stack/{cityName}")
    public String getCurrentWeather1(@PathVariable("cityName") String cityName) {
        String url = WEATHER_STACK_API + "current" + "?access_key=" + WEATHER_STACK_API_KEY + "&query=" + cityName;
        WeatherStackResponse response = restTemplate.getForObject(url, WeatherStackResponse.class);
        log.info("weatherstack response {}", response);
        return null;
    }

    @GetMapping("open-weather/{cityName}")
    public String getCurrentWeather2(@PathVariable("cityName") String cityName) {
        String url = OPEN_WEATHER_API + "weather" + "?q=" + cityName + "&appId=" + OPEN_WEATHER_API_KEY;
        OpenWeatherResponse response = restTemplate.getForObject(url, OpenWeatherResponse.class);
        log.info("openweathermap response {}", response);
        return null;
    }

    @PostMapping("/location")
    public ResponseEntity<Location> addLocation(@RequestBody @Valid LocationRequest locationRequest) {
        log.info("save location: {}", locationRequest);
        return ResponseEntity.ok(weatherService.saveLocation(locationRequest));
    }

    @GetMapping("location/{cityName}")
    public ResponseEntity<Location> getLocation(@PathVariable("cityName") String cityName) {
        log.info("find location by city name: {}", cityName);
        return ResponseEntity.ok(weatherService.findByLocationName(cityName));
    }

    @GetMapping("location")
    public ResponseEntity<List<Location>> getLocations() {
        log.info("find all locations");
        return ResponseEntity.ok(weatherService.findAll());
    }

    @PutMapping("/location/{id}")
    public ResponseEntity<Location> addLocation(@RequestBody @Valid LocationRequest locationRequest, @PathVariable Long id) {
        log.info("update location id: {} with data: {}", id, locationRequest);
        return ResponseEntity.ok(weatherService.updateLocation(id, locationRequest));
    }
}
