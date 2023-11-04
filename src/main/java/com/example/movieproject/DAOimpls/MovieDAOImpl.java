package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.MovieMapping;
import com.example.movieproject.models.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements DAO<Movie> {

    Connection conn;

    public MovieDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();
    }

    @Override
    public void create(Movie obj) {

    }

    @Override
    public Movie get(long id) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from movies where id = ?");
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return MovieMapping.getMovie(res);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Movie entity) {

    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from movies");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                movies.add(MovieMapping.getMovie(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        movies.forEach(System.out::println);
        return movies;
    }
}
