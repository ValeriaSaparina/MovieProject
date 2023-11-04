package com.example.movieproject.mappings;

import com.example.movieproject.models.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapping {
    public static Review getReview(ResultSet res) throws SQLException {
        return new Review(res.getLong("id"), res.getLong("userID"), res.getLong("movieID"),
                res.getString("title"), res.getString("type"), res.getString("text"), res.getDate("date").toLocalDate(), res.getDouble("rating"));
    }
}
