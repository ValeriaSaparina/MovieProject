package com.example.movieproject.Helpers.services;

import com.example.movieproject.models.Review;

import javax.servlet.ServletContext;
import java.util.*;
import java.util.stream.Collectors;

public class ReviewService {

    private ServletContext context;
    public ReviewService(ServletContext context) {
        this.context = context;
    }

    public HashMap<Long, Integer> getNumberOfReviewsForEachMovie(List<Review> allReviews) {
        HashMap<Long, Integer> result = new HashMap<>();
        for (Review review : allReviews) {
            long movieId = review.getMovieID();
            if (!result.containsKey(movieId)) {
                result.put(movieId, 1);
            } else {
                result.replace(movieId, result.get(movieId) + 1);
            }
        }
        return result;
    }

    public HashMap<Long, Integer> sort(HashMap<Long, Integer> reviews) {
        return reviews.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
    }

    public HashMap<Long, Integer> sort(List<Review> reviewList) {
        return getNumberOfReviewsForEachMovie(reviewList).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
    }

    public HashMap<Long, Integer> reverseOrderSort(HashMap<Long, Integer> reviews) {
        return reviews.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
    }

    public HashMap<Long, Integer> reverseOrderSort(List<Review> reviewList) {
        return getNumberOfReviewsForEachMovie(reviewList).entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
    }

}
