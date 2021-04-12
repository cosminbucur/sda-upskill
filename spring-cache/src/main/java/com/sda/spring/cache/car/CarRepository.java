package com.sda.spring.cache.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByOwner(String owner);

    List<Car> findByBrand(String brand);

}
