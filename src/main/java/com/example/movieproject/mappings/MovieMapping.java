package com.example.movieproject.mappings;

import com.example.movieproject.models.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapping {

    public static Movie getMovie(ResultSet res) throws SQLException {
        return new Movie(res.getLong("id"), res.getString("localname"), res.getString("originalname"),
                res.getDate("releaseworld"), res.getDate("releaserussia"),
                res.getString("description"), res.getString("country"), res.getDouble("rating"), res.getInt("durationminutes"), res.getString("agelimit"));
    }

}
