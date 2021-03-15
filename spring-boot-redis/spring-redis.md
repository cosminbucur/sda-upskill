## docs

https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-caching.html#boot-features-caching-provider-redis

## dependencies

- spring boot redis
- jedis

## config

- enable caching

## spring cache

- create model
    - car
    - CarRepository
    - ICarService
    - CarService
        - @Cacheable
        - @CachePut
        - @CacheEvict

- main class

- configure h2 database in application.yml

## setup caching

- add dependencies

- add test