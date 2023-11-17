package com.example.movieproject.models;

import java.time.LocalDate;
import java.util.HashMap;

public class Review {
    private long reviewID;
    private long userID;
    private long movieID;
    private String title;
    private String type;
    private String text;
    private LocalDate date;
    private double rating;

    public Review(long reviewID, long userID, long movieID, String title, String type, String text, LocalDate date, double rating) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.movieID = movieID;
        this.title = title;
        this.type = type;
        this.text = text;
        this.date = date;
        this.rating = rating;
    }

    public Review(long userID, long movieID, String title, String type, String text, LocalDate date, double rating) {
        this.userID = userID;
        this.movieID = movieID;
        this.title = title;
        this.type = type;
        this.text = text;
        this.date = date;
        this.rating = rating;
    }

    public long getReviewID() {
        return reviewID;
    }

    public void setReviewID(long reviewID) {
        this.reviewID = reviewID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getMovieID() {
        return movieID;
    }

    public void setMovieID(long movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", userID=" + userID +
                ", movieID=" + movieID +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                '}';
    }
}
