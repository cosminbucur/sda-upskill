package com.sda.spring.boot.redis.car;

import java.util.List;

public interface ICarService {

    Car save(Car car);

    List<Car> findAll();

    Car findById(Long id);

    Car findByOwner(String owner);

    List<Car> findByBrand(String brand);

    Car update(Long id, Car updateInfo);

    void delete(Long id);

    void clearCache();
}
