package com.example.movieproject.mappings;

import com.example.movieproject.models.FavoriteMovie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteMovieMapping {
    public static FavoriteMovie getFavoriteMovie(ResultSet res) throws SQLException {
        return new FavoriteMovie(res.getLong("movieId"), res.getLong("userId"));
    }
}
