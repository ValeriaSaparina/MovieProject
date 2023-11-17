package com.example.movieproject.models;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private long id;
    private String originalName;
    private String localName;
    private Director director;
    private ArrayList<Producer> producers;
    private ArrayList<Actor> actors;
    private ArrayList<Screenwriter> composers;
    private Date releaseWorld;
    private Date releaseRussia;
    private String description;
    private String country;
    private double rating;
    private int durationMinutes;
    private String ageLimit;
    private String posterPath;

    public Movie(long id, String localName, String originalName, java.sql.Date releaseWorld, java.sql.Date releaseRussia,
                 String description, String country, double rating, int durationMinutes, String ageLimit, String posterPath) {
        this.id = id;
        this.localName = localName;
        this.originalName = originalName;
        this.releaseWorld = releaseWorld;
        this.releaseRussia = releaseRussia;
        this.description = description;
        this.country = country;
        this.rating = rating;
        this.durationMinutes = durationMinutes;
        this.ageLimit = ageLimit;
        this.posterPath = posterPath;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }

    public void setProducers(ArrayList<Producer> producers) {
        this.producers = producers;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public ArrayList<Screenwriter> getComposers() {
        return composers;
    }

    public void setComposers(ArrayList<Screenwriter> composers) {
        this.composers = composers;
    }

    public Date getReleaseWorld() {
        return releaseWorld;
    }

    public void setReleaseWorld(Date releaseWorld) {
        this.releaseWorld = releaseWorld;
    }

    public Date getReleaseRussia() {
        return releaseRussia;
    }

    public void setReleaseRussia(Date releaseRussia) {
        this.releaseRussia = releaseRussia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", originalName='" + originalName + '\'' +
                ", localName='" + localName + '\'' +
                ", releaseWorld=" + releaseWorld +
                ", releaseRussia=" + releaseRussia +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", durationMinutes=" + durationMinutes +
                ", ageLimit='" + ageLimit + '\'' +
                '}';
    }
}
