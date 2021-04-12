package com.sda.spring.webflux;

import com.sda.spring.webflux.model.Book;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WebFluxConcepts {

    public static void main(String[] args) {
        List<Book> bookList = findAllWithCollections();
        Stream<Book> bookSteam = findAllWithStreams();
        Flux<Book> bookFlux = findAllWithFlux();
        useSubscriber();
    }

    public static List<Book> findAllWithCollections() {
        return Arrays.asList(
                new Book("1", "book1", "author1"),
                new Book("2", "book2", "author2")
        );
    }

    public static Stream<Book> findAllWithStreams() {
        return Stream.of(
                new Book("1", "book1", "author1"),
                new Book("2", "book2", "author2")
        );
    }

    // publisher
    public static Flux<Book> findAllWithFlux() {
        return Flux.just(
                new Book("1", "book1", "author1"),
                new Book("2", "book2", "author2")
        );
    }

    // subscriber
    public static void useSubscriber() {
        Flux.just(1, 2, 3, 4)
                .reduce(Integer::sum)
                .subscribe(sum -> System.out.println("sum is: " + sum));
    }
}
