package com.sda.spring.boot.redis.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = {"cars"})
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
    // if default cache, in cache => cars::SimpleKey[]
    @Override
    public List<Car> findAll() {
        log.info("---------------------- findAll() from db");
        return carRepository.findAll();
    }

    // in cache => cars::2
    @Cacheable(key = "#id")
    @Override
    public Car findById(Long id) {
        log.info("---------------------- findById() from db");
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("car not found"));
    }

    // unless - return value
    @Cacheable(unless = "#owner == 'cristi'")
    @Override
    public Car findByOwner(String owner) {
        log.info("---------------------- findByOwner() from db");
        return carRepository.findByOwner(owner);
    }

    // condition - return list
    @Cacheable(condition = "#brand == 'bmw'")
    @Override
    public List<Car> findByBrand(String brand) {
        log.info("---------------------- findByBrand() from db");
        return carRepository.findByBrand(brand);
    }

    // the body of the update() method will always be executed
    @CachePut(key = "#id")
    @Override
    public Car update(Long id, Car updateInfo) {
        log.info("---------------------- update() from db");

        return carRepository.findById(id)
                .map(car -> {
                    car.setOwner(updateInfo.getOwner());
                    car.setBrand(updateInfo.getBrand());
                    car.setModel(updateInfo.getModel());
                    car.setPrice(updateInfo.getPrice());
                    return carRepository.save(car);
                })
                .orElseThrow(() -> new RuntimeException("car not found"));
    }

    @CacheEvict(key = "#id")
    @Override
    public void delete(Long id) {
        log.info("---------------------- delete() from db");
        carRepository.deleteById(id);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void clearCache() {
        log.info("---------------------- clearCache()");
    }
}
