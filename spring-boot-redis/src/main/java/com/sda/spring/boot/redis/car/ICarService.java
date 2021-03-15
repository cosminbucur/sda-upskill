package com.sda.spring.boot.redis.car;

import java.util.List;

public interface ICarService {

    Car save(Car car);

    List<Car> findAll();

    List<Car> findByBrand(String brand);

    Car findById(Long id);

    Car update(Long id, Car car);

    void delete(Long id);
}
