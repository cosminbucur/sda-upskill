package com.sda.spring.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class WebClientTest {

    private static final String BOOKS_RESOURCE = "http//localhost:8081/books/";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGet() {
        webTestClient
                .get()
                .uri(BOOKS_RESOURCE)

                .accept(MediaType.APPLICATION_JSON)

                .exchange()

                // check status
                .expectStatus().isOk()

                // check header
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)

                // check cookie
                .expectCookie()
                .exists("some cookie")

                // check body
//                .expectBody(String.class).isEqualTo("result");
                .expectBody().json("{ json string }");
    }
}
