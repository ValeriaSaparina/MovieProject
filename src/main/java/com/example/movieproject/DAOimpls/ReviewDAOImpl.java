package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.ReviewMapping;
import com.example.movieproject.models.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements DAO<Review> {

    private Connection conn;

    public ReviewDAOImpl() {
        conn = JDBCConnection.getConn();
    }

    @Override
    public void create(Review review) {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "insert into reviews (userId, movieId, title, text, type, date, rating) " +
                            "values (?, ?, ?, ?, ?, ?, ?)");
            statement.setLong(1, review.getUserID());
            statement.setLong(2, review.getMovieID());
            statement.setString(3, review.getTitle());
            statement.setString(4, review.getText());
            statement.setString(5, review.getType());
            statement.setDate(6, Date.valueOf(review.getDate()));
            statement.setDouble(7, review.getRating());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Review get(long id) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from reviews where id = ?");
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return ReviewMapping.getReview(res);
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void update(Review entity) {

    }

    @Override
    public List<Review> getAll() {
        List<Review> reviews = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from reviews");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                reviews.add(ReviewMapping.getReview(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    public List<Review> getByMovieID(int movieID) {
        List<Review> reviews = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from reviews where movieid = ?");
            statement.setLong(1, movieID);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                reviews.add(ReviewMapping.getReview(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }
}
