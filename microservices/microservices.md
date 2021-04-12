## catalog API

onlinebooks.com/api/userId

```json
{
  "id": "userId",
  "name": "Jon Snow",
  "books": [
    {
      "id": 1234,
      "title": "test1",
      "author": "author1",
      "rating": 5
    },
    {
      "id": 1234,
      "title": "test2",
      "author": "author2",
      "rating": 4
    }
  ]
}
```

## microservices

- [catalog](http://localhost:8081/catalog/userId) book-catalog-service
- [books](http://localhost:8082/books/bookId) book-info-service
- [ratings](http://localhost:8083/ratings/users/userId) ratings-data-service
- [gateway](http://localhost:8084)  api-gateway

## security

[basic auth header generator](https://www.blitter.se/utils/basic-authentication-header-generator/)

## service discovery

### client side service discovery

- a discovery server between the client and services
- each service registers to the discovery server
- the client gets the address from the discovery server
- the client calls the service
- used by spring cloud

### server side client discovery

- client sends the message to the discovery server
- discovery server sends the message to the correct service

# tutorial

- create eureka discovery server
  [eureka](http://localhost:8761/)
- create eureka clients
- register services
- consume services

- configure rest template to use service discovered urls

  @LoadBalanced eureka knows service names http://[service name]/api

  - [books](http://book-info-service/books/bookId)
  - [ratings](http://ratings-data-service/ratings/users/userId)

- create zuul gateway

http://localhost<zuul-service-port>/api/books/bookId

http://localhost:8084/api/books/bookId

# how to run

- deploy eureka
- deploy api-gateway
- deploy other services