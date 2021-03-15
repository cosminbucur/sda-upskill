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
    // in cache => cars::SimpleKey[]
    @Cacheable
    @Override
    public List<Car> findAll() {
        log.info("---------------------- findAll() from db");
        return carRepository.findAll();
    }

    @Cacheable
    @Override
    public List<Car> findByBrand(String brand) {
        return null;
    }

    // in cache => cars::1
    @Cacheable
    @Override
    public Car findById(Long id) {
        log.info("---------------------- findById() from db");
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("car not found"));
    }

    // the body of the update() method will always be executed
    @CachePut(key = "#car.id")
    @Override
    public Car update(Long id, Car car) {
        log.info("---------------------- update() from db");
        if (carRepository.existsById(id)) {
            return carRepository.save(car);
        }
        throw new IllegalArgumentException("id needed");
    }

    /*
    @Caching(evict = {
      @CacheEvict("addresses"),
      @CacheEvict(value="directory", key="#customer.name") })

      @CachePut(value="addresses", condition="#customer.name=='Tom'")

      @CachePut(value="addresses", unless="#result.length()<64")
     */

    //    @CacheEvict(value = "users", allEntries=true)
    @CacheEvict(key = "#id")
    @Override
    public void delete(Long id) {
        log.info("---------------------- delete() from db");
        carRepository.deleteById(id);
    }
}
