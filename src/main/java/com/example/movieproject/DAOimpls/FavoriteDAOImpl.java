package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.FavoriteMovieMapping;
import com.example.movieproject.models.FavoriteMovie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDAOImpl implements DAO<FavoriteMovie> {

    private Connection conn;

    public FavoriteDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();
    }

    @Override
    public void create(FavoriteMovie obj) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into favoritemovies (movieid, userid) values (?, ?)");
            statement.setLong(1, obj.getMovieID());
            statement.setLong(2, obj.getUserID());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(FavoriteMovie obj) {
        try {
            PreparedStatement statement = conn.prepareStatement("delete from favoritemovies where movieid = ? and userid = ?");
            statement.setLong(1, obj.getMovieID());
            statement.setLong(2, obj.getUserID());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FavoriteMovie get(long id) {
        return null;
    }

    @Override
    public void update(FavoriteMovie entity) {

    }

    @Override
    public List<FavoriteMovie> getAll() {
        return null;
    }

    public List<FavoriteMovie> getByUserId(long userId) {
        try {
            List<FavoriteMovie> favoriteMovies = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement("select * from favoritemovies where userid = ?");
            statement.setLong(1, userId);
            ResultSet res = statement.executeQuery();
            while(res.next()) {
                favoriteMovies.add(FavoriteMovieMapping.getFavoriteMovie(res));
            }
            return favoriteMovies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
