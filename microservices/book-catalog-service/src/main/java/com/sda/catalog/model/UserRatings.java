package com.sda.catalog.model;

import java.util.ArrayList;
import java.util.List;

public class UserRatings {

    private List<Rating> ratings = new ArrayList<>();

    public UserRatings() {
    }

    public UserRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
