package com.sda.spring.webflux;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.net.URI;
import java.util.concurrent.TimeUnit;

public class CustomWebClient {

    public static final String BASE_URL = "http://localhost:8081";

    public void main() {

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

        WebClient client = WebClient.builder()
                .baseUrl(BASE_URL)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    public void post() {
        WebClient.RequestHeadersSpec requestSpec1 = WebClient
                .create()
                .method(HttpMethod.POST)
                .uri("/resource")
                .body(BodyInserters.fromPublisher(Mono.just("data"), String.class));


    }

    public void post2() {
        WebClient.RequestHeadersSpec<?> requestSpec2 = WebClient
                .create("http://localhost:8080")
                .post()
                .uri(URI.create("/resource"))
                .body(BodyInserters.fromValue("data"));
    }

    public void useBodyInserter() {
        LinkedMultiValueMap map = new LinkedMultiValueMap();

        map.add("key1", "value1");
        map.add("key2", "value2");

        BodyInserter<MultiValueMap<String, Object>, ClientHttpRequest> inserter2 =
                BodyInserters.fromMultipartData(map);
    }

    public void stuff() {
//        WebClient.ResponseSpec response1 = uri1
//                .body(inserter3)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
//                .acceptCharset(Charset.forName("UTF-8"))
//                .ifNoneMatch("*")
//                .ifModifiedSince(ZonedDateTime.now())
//                .retrieve();
    }

    public void getResponse() {
//        String response2 = uri1.exchangeToMono(
//                response -> response.bodyToMono(String.class))
//                .block();
//        String response3 = uri2.retrieve()
//                .bodyToMono(String.class)
//                .block();
    }
}
