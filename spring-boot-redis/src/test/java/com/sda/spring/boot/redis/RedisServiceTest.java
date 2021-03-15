package com.sda.spring.boot.redis;

import com.sda.spring.boot.redis.car.Car;
import com.sda.spring.boot.redis.car.CarService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class RedisServiceTest {

    @Autowired
    private CarService carService;

    @Test
    @Order(1)
    void findAll() {
        carService.save(new Car("audi", "a4", 20000));
        carService.save(new Car("bmw", "x1", 30000));
        carService.save(new Car("dacia", "duster", 16000));

        carService.findAll();
        List<Car> actual = carService.findAll();

        // redis: should have an entry in cache cars::SimpleKey []
        assertThat(actual).hasSize(3);
    }

    @Test
    @Order(2)
    void findById() {
        carService.save(new Car("audi", "a4", 20000));
        Car bmw = carService.save(new Car("bmw", "x1", 30000));

        carService.findById(bmw.getId());
        Car actual = carService.findById(bmw.getId());

        // redis: should have 1 entry in cache cars::2
        assertThat(actual).isNotNull();
    }

    @Test
    @Order(3)
    void update() {
        Car bmw = carService.save(new Car("bmw", "x1", 30000));
        Car updateData = new Car("bmw", "x5", 40000);

        Car actual = carService.update(bmw.getId(), updateData);

        // redis: should have 1 entry in cache cars::2
        assertThat(actual.getModel()).isEqualTo(updateData.getModel());
        assertThat(actual.getPrice()).isEqualTo(updateData.getPrice());
    }

    @Test
    @Order(4)
    void delete() {
        carService.save(new Car("audi", "a4", 20000));
        Car bmw = carService.save(new Car("bmw", "x1", 30000));

        carService.delete(bmw.getId());

        // redis: should have no entry in cache
        assertThat(carService.findAll()).hasSize(1);
    }
}