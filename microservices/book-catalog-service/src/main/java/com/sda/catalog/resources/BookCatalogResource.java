package com.sda.catalog.resources;

import com.sda.catalog.model.Book;
import com.sda.catalog.model.CatalogItem;
import com.sda.catalog.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/catalog")
@RestController
public class BookCatalogResource {

    // hard coded urls
//    private static final String BOOKS_RESOURCE = "http://localhost:8082/books/";
//    private static final String RATINGS_RESOURCE = "http://localhost:8083/ratings/";

    // service discovered urls
    private static final String BOOKS_RESOURCE = "http://book-info-service/books/";
    private static final String RATINGS_RESOURCE = "http://ratings-data-service/ratings/";

    private final RestTemplate restTemplate;

    @Autowired
    public BookCatalogResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        // get all rated books ids, call ratings-data-service
        UserRatings ratings = restTemplate.getForObject(RATINGS_RESOURCE + "users/" + userId, UserRatings.class);

        // get each book id, call book-info-service and get details
        return ratings.getRatings().stream()
                // make a call cor each book
                .map(rating -> {
                    // get book
                    // perform API call
                    // unmarshal in object from json
                    Book book = restTemplate.getForObject(BOOKS_RESOURCE + rating.getBookId(), Book.class);

                    // put data together
                    return new CatalogItem(
                            book.getBookId(),   // from book info service
                            book.getTitle(),
                            book.getAuthor(),
                            rating.getBookRating());  // from rating service
                })
                .collect(Collectors.toList());
    }
}
