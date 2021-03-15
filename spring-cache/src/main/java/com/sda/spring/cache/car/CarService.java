package com.sda.spring.cache.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    // Spring Cache uses the parameters of the method as key and the return value as a value in the cache
    @Cacheable(value = "cars")
    @Override
    public List<Car> findAll() {
        log.info("---------------------- findAll() from db");
        return carRepository.findAll();
    }

    @Cacheable(value = "cars")
    @Override
    public List<Car> findByBrand(String brand) {
        return null;
    }

    @Cacheable(value = "cars")
    @Override
    public Car findById(Long id) {
        log.info("---------------------- findById() from db");
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("car not found"));
    }

    // the body of the update() method will always be executed
    @CachePut(value = "cars", key = "#car.id")
    @Override
    public Car update(Long id, Car car) {
        log.info("---------------------- update() from db");
        if (carRepository.existsById(id)) {
            return carRepository.save(car);
        }
        throw new IllegalArgumentException("id needed");
    }

    @CacheEvict(value = "cars", key = "#id")
    @Override
    public void delete(Long id) {
        log.info("---------------------- delete() from db");
        carRepository.deleteById(id);
    }
}
