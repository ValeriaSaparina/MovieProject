package com.example.movieproject.models;

public class FavoriteMovie {
    private long movieID;
    private long userID;

    public FavoriteMovie(long movieID, long userID) {
        this.movieID = movieID;
        this.userID = userID;
    }

    public long getMovieID() {
        return movieID;
    }

    public void setMovieID(long movieID) {
        this.movieID = movieID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
