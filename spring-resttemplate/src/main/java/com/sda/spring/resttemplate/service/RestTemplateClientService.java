package com.sda.spring.resttemplate.service;

import com.sda.spring.resttemplate.dto.BookRequest;
import com.sda.spring.resttemplate.dto.BookResponse;
import com.sda.spring.resttemplate.dto.BookResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RestTemplateClientService {

    // check url
    private static final String BOOKS_RESOURCE = "http://localhost:8081/books";
    private static final Logger log = LoggerFactory.getLogger(RestTemplateClientService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateClientService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    // CRUD

    // POST http://localhost:8081/books body: book
    public BookResponse save(BookRequest request) {
        log.info("rest template create");
        return restTemplate.postForObject(BOOKS_RESOURCE, request, BookResponse.class);
    }

    // GET http://localhost:8081/books
    public List<BookResponse> findAll() {
        log.info("rest template find all");

        ResponseEntity<BookResponse[]> response =
                restTemplate.getForEntity(
                        BOOKS_RESOURCE,
                        BookResponse[].class);
        BookResponse[] responses = response.getBody();
        return Arrays.asList(responses);
    }

    // TIP: good practice is to wrap lists in object
    // GET http://localhost:8081/books
    public BookResponseList findAllUsingWrapperClass() {
        log.info("rest template find all");
        return restTemplate.getForObject(BOOKS_RESOURCE, BookResponseList.class);
    }

    // GET http://localhost:8081/books/{bookId}
    public BookResponse findById(Long bookId) {
        log.info("rest template find by id");
        return restTemplate.getForObject(BOOKS_RESOURCE + "/" + bookId, BookResponse.class);
    }

    // PUT http://localhost:8081/books body: book
    public void update(Long id, BookRequest request) {
        log.info("rest template update");
        restTemplate.put(BOOKS_RESOURCE + "/" + id, request);
    }

    // DELETE http://localhost:8081/books/{bookId}
    public void delete(Long bookId) {
        log.info("rest template delete");

        // can use map to set params
        Map<String, Long> params = Map.of("bookId", bookId);
        restTemplate.delete(BOOKS_RESOURCE + "/" + bookId, params);
    }

}
