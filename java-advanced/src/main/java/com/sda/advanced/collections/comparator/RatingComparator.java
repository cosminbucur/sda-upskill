package com.sda.advanced.collections.comparator;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

    // DONE: compare by rating descending using Comparator
    @Override
    public int compare(Movie one, Movie other) {
        return Integer.compare(other.getRating(), one.getRating());
    }

    public int compareLongVersion(Movie one, Movie other) {
        if (one.getRating() < other.getRating()) {
            return -1;
        }
        if (one.getRating() > other.getRating()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compareShortVersion(Movie one, Movie other) {
        return Integer.compare(one.getRating(), other.getRating());
    }
}