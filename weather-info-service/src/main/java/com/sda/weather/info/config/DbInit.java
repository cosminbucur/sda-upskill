package com.sda.weather.info.config;

import com.sda.weather.info.model.Location;
import com.sda.weather.info.model.LocationRepository;
import com.sda.weather.info.model.WeatherInfo;
import com.sda.weather.info.model.WeatherInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DbInit {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private WeatherInfoRepository weatherInfoRepository;

    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            Location location = new Location("test", 123L, -25L, "region", "country");
            Location savedLocation = locationRepository.save(location);

            WeatherInfo weatherInfo = new WeatherInfo(LocalDate.now(), 123L, 234L, 345L, "NE");
            weatherInfo.setLocation(savedLocation);

            weatherInfoRepository.save(weatherInfo);
        };
    }
}
