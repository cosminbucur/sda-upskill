package com.sda.weather.info.controller;

import com.sda.weather.info.openweather.OpenWeatherResponse;
import com.sda.weather.info.weatherstack.WeatherStackResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/weather")
@RestController
public class WeatherResource {

    private static final Logger log = LoggerFactory.getLogger(WeatherResource.class);
    private static final String OPEN_WEATHER_API = "http://api.openweathermap.org/data/2.5/";
    private static final String OPEN_WEATHER_API_KEY = "bc3d654cabcea5227406acdf1d502154";

    private static final String WEATHER_STACK_API = "http://api.weatherstack.com/";
    private static final String WEATHER_STACK_API_KEY = "3f4930f840181ae139b5c17037376f2c";

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // fetch weather values
    @GetMapping("weather/{cityName}")
    public String getCurrentWeather(@PathVariable("cityName") String cityName) {
        String url = OPEN_WEATHER_API + "?q=" + cityName + "&appId=" + OPEN_WEATHER_API_KEY;
        OpenWeatherResponse response = restTemplate.getForObject(url, OpenWeatherResponse.class);
        log.info("openweathermap response {}", response);
        return null;
    }

    @GetMapping("current/{cityName}")
    public String getCatalog(@PathVariable("cityName") String cityName) {
        String url = WEATHER_STACK_API + "current" + "?access_key=" + WEATHER_STACK_API_KEY + "&query=" + cityName;
        WeatherStackResponse response = restTemplate.getForObject(url, WeatherStackResponse.class);
        log.info("weatherstack response {}", response);
        return null;
    }

    // add location to database

    // display locations


}
