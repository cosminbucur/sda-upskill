## chrome plugin

[JSONView](https://chrome.google.com/webstore/detail/jsonview/chklaanhfefbnpoihckbnefhakgolnmc?hl=en)

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

- [catalog](http://localhost:8081/catalog/userId)
- [books](http://localhost:8082/books/bookId)
- [ratings](http://localhost:8083/ratings/users/userId)

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
