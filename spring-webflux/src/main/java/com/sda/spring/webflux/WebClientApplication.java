package com.sda.spring.webflux;

import com.sda.spring.webflux.model.Book;
import com.sda.spring.webflux.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebClientApplication {

    @Autowired
    private WebClientService webClientService;

    public static void main(String[] args) {
        SpringApplication.run(WebClientApplication.class, args);
    }

    @Bean
    private CommandLineRunner testWebClient() {
        return (args) -> {
            Book book1 = new Book("1", "book1", "author1");
            Book book2 = new Book("2", "book2", "author2");
            Mono<Book> savedBook1 = webClientService.save(book1);
            Mono<Book> savedBook2 = webClientService.save(book2);

            webClientService.findAll();

            String bookId1 = savedBook1.block().getBookId();
            webClientService.findById(bookId1);

            Mono<Book> updatedMono = webClientService.update(book1);
            Book updatedBook = savedBook1.block();

            String bookId2 = savedBook2.block().getBookId();
            webClientService.delete(bookId2);
        };
    }
}
