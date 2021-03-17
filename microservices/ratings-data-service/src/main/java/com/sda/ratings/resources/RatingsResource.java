package com.sda.ratings.resources;

import com.sda.ratings.model.Rating;
import com.sda.ratings.model.UserRatings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ratings")
@RestController
public class RatingsResource {

    @GetMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 5);
    }

    // avoid returning lists in APIs, in case we make changes
    @GetMapping("/users/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1111", 5),
                new Rating("2222", 4)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setRatings(ratings);
        return userRatings;
    }
}
