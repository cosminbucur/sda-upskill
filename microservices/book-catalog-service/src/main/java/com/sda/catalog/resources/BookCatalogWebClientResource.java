package com.sda.catalog.resources;

import com.sda.catalog.model.Book;
import com.sda.catalog.model.CatalogItem;
import com.sda.catalog.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/catalog-new")
@RestController
public class BookCatalogWebClientResource {

    private static final String BOOKS_RESOURCE = "http//localhost:8082/books/";
    private static final String RATINGS_RESOURCE = "http//localhost:8083/ratings/";
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public BookCatalogWebClientResource(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    // in production should return mono instead of list
    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        // get all rated books ids, call ratings-data-service
        UserRatings ratings = webClientBuilder.build()
                .get()
                .uri(RATINGS_RESOURCE + userId)
                .retrieve()
                .bodyToMono(UserRatings.class)
                .block();

        // get each book id, call book-info-service and get details
        return ratings.getRatings().stream()
                // make a call cor each book
                .map(rating -> {
                    Book book = webClientBuilder.build()
                            // rest verb
                            .get()
                            .uri(BOOKS_RESOURCE + rating.getBookId())
                            // rest call execution
                            .retrieve()
                            // convert response to object
                            // mono = reactive concept, the result from the future as an async object
                            .bodyToMono(Book.class)
                            // block execution till mono is complete
                            .block();

                    return new CatalogItem(
                            rating.getBookId(),
                            book.getTitle(),
                            book.getAuthor(),
                            rating.getBookRating());
                })
                .collect(Collectors.toList());
    }
}
