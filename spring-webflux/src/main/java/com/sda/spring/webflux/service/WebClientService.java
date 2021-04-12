package com.sda.spring.webflux.service;

import com.sda.spring.webflux.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    // check url
    private static final String BOOKS_RESOURCE = "http//localhost:8082/books/";
    private static final Logger log = LoggerFactory.getLogger(WebClientService.class);

    private final WebClient webClient;

    @Autowired
    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Book getBookBlocking(String bookId) {
        log.info("web client synchronous rest call");
        return webClient
                // rest verb
                .get()
                // location of request
                .uri(BOOKS_RESOURCE + bookId)
                // rest call execution
                .retrieve()
                // convert response to object
                // mono = reactive concept, the result from the future as an async object
                .bodyToMono(Book.class)
                // block execution till mono is complete
                .block();
    }

    // POST http://localhost:8082/books body: book
    public Mono<Book> save(Book book) {
        log.info("web client create");
        return webClient.post()
                .uri(BOOKS_RESOURCE)
                .body(Mono.just(book), Book.class)
                .retrieve()
                .bodyToMono(Book.class);
    }

    // GET http://localhost:8082/books
    public Flux<Book> findAll() {
        log.info("web client find all");
        return webClient.get()
                .uri(BOOKS_RESOURCE)
                .retrieve()
                .bodyToFlux(Book.class);
    }

    // GET http://localhost:8082/books/{bookId}
    public Mono<Book> findById(String bookId) {
        log.info("web client find by id");
        return webClient.get()
                .uri(BOOKS_RESOURCE + bookId)
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        clientResponse -> Mono.empty())
                .bodyToMono(Book.class);
    }

    // PUT http://localhost:8082/books body: book
    public Mono<Book> update(Book book) {
        log.info("web client update");
        return webClient.put()
                .uri(BOOKS_RESOURCE + book.getBookId())
                .body(Mono.just(book), Book.class)
                .retrieve()
                .bodyToMono(Book.class);
    }

    // DELETE http://localhost:8082/books/{bookId}
    public Mono<Void> delete(String bookId) {
        log.info("web client delete");
        return webClient.delete()
                .uri(BOOKS_RESOURCE + bookId)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
