package com.sda.spring.boot.redis.car;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class RedisServiceTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CarService carService;

    private Car bmw;

    @BeforeEach
    void setUp() {
        carService.findAll()
                .forEach(car -> carService.delete(car.getId()));

        Car audi = new Car("bianca", "audi", "a4", 20000);
        bmw = new Car("cristi", "bmw", "x1", 30000);
        carService.save(audi);
        carService.save(bmw);
    }

    @Order(1)
    @Test
    void whenFindAll_return2Cars() {
        // given

        // when
        List<Car> actual = carService.findAll();

        // then
        assertThat(actual).hasSize(2);
    }

    @Order(2)
    @Test
    void whenFindById_shouldCacheCar() {
        // given

        // when
        Car actual = carService.findById(bmw.getId());

        // then
        Cache carsCache = cacheManager.getCache("cars");
        Car carFromCache = carsCache.get(bmw.getId(), Car.class);

        assertThat(actual).isEqualTo(carFromCache);
    }

    @Order(3)
    @Test
    void whenFindByOwner_shouldCacheResult() {
        // given

        // when
        Car actual = carService.findByOwner("bianca");

        // then
        Cache carsCache = cacheManager.getCache("cars");
        Car cachedCar = carsCache.get("bianca", Car.class);

        assertThat(actual).isEqualTo(cachedCar);
    }

    @Order(4)
    @Test
    void whenFindByOwnerNotCacheable_shouldNotCacheResult() {
        // given

        // when
        Car actual = carService.findByOwner("cristi");

        // then
        Cache carsCache = cacheManager.getCache("cars");
        Car nullCar = carsCache.get("cristi", Car.class);

        assertThat(actual.getOwner()).isEqualTo("cristi");
        assertThat(nullCar).isNull();
    }

    @Order(5)
    @Test
    void whenFindByBrand_shouldCacheResult() {
        // given
        Car biggerBmw = new Car("elena", "bmw", "x5", 40000);
        carService.save(biggerBmw);

        // when
        List<Car> actual = carService.findByBrand(bmw.getBrand());

        // then
        Cache carsCache = cacheManager.getCache("cars");
        Cache.ValueWrapper valueWrapper = carsCache.get(bmw.getBrand());
        List<Car> cachedCars = (List<Car>) valueWrapper.get();

        assertThat(actual).isEqualTo(cachedCars);
    }

    @Order(6)
    @Test
    void whenFindByBrand_shouldNotCacheResult() {
        // given

        // when
        List<Car> actual = carService.findByBrand("audi");

        // then
        Cache carsCache = cacheManager.getCache("cars");
        Cache.ValueWrapper valueWrapper = carsCache.get("audi");

        assertThat(actual).isNotNull();
        assertThat(valueWrapper).isNull();
    }

    @Order(7)
    @Test
    void whenUpdate_shouldUpdateCache() {
        // given
        Car updateData = new Car("elena", "bmw", "x5", 40000);

        // when
        Car actual = carService.update(bmw.getId(), updateData);

        // then
        Cache carsCache = cacheManager.getCache("cars");
        Car carFromCache = carsCache.get(bmw.getId(), Car.class);

        assertThat(actual.getModel()).isEqualTo(updateData.getModel());
        assertThat(actual.getPrice()).isEqualTo(updateData.getPrice());
        assertThat(actual).isEqualTo(carFromCache);
    }

    @Order(8)
    @Test
    void whenDelete_thenEmptyCache() {
        // given
        // add to cache
        carService.findById(bmw.getId());

        // when
        carService.delete(bmw.getId());
        Cache carsCache = cacheManager.getCache("cars");
        Car nullCar = carsCache.get(bmw.getId(), Car.class);

        assertThat(carService.findAll()).hasSize(1);
        assertThat(nullCar).isNull();
    }

    @Order(9)
    @Test
    void whenClearCache_thenEmptyCache() {
        // given
        // add to cache
        carService.findById(bmw.getId());

        // when
        carService.clearCache();
        Cache carsCache = cacheManager.getCache("cars");
        Car nullCar = carsCache.get(bmw.getId(), Car.class);

        assertThat(carService.findAll()).hasSize(2);
        assertThat(nullCar).isNull();
    }
}