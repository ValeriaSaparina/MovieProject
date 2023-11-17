package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.MovieMapping;
import com.example.movieproject.models.FavoriteMovie;
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
        return movies;
    }

    public List<Movie> getByQuery(String query) {
        List<Movie> movies = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                movies.add(MovieMapping.getMovie(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public List<Movie> getByLikePattern(String pattern) {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "select * from movies where lower(movies.localname) like ? or lower(movies.originalname) like ?;");
            statement.setString(1, "%" + pattern + "%");
            statement.setString(2, "%" + pattern + "%");
            ResultSet res = statement.executeQuery();
            List<Movie> movies = new ArrayList<>();
            while (res.next()) {
                movies.add(MovieMapping.getMovie(res));
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getByParameter(String pattern, String[] names, String[] values) {
        try {
            String query = getQuery(names, values);
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%" + pattern + "%");
            statement.setString(2, "%" + pattern + "%");

            int pos = 3;
            if (!values[0].isEmpty()) {
                statement.setString(pos, values[0]);
                pos++;
            }
            if (!values[1].isEmpty()) {
                statement.setDouble(pos, Double.parseDouble(values[1]));
                pos++;
            }
            if (!values[2].isEmpty()) {
                statement.setString(pos, (values[2]));
            }

            List<Movie> movies = new ArrayList<>();
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                movies.add(MovieMapping.getMovie(res));
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getQuery(String[] names, String[] values) {
        String query = "select * from movies where (lower(movies.localname) like ? or lower(movies.originalname) like ?)";
        for (int i = 0; i < names.length; i++) {
            if (!values[i].isEmpty()) {
                query += " and " + names[i];
                if (names[i].equals("rating")) query += " >=";
                else query += " =";
                query += " ?";
            }
        }
        query += ";";
        return query;
    }

    public List<Movie> getMoviesByList(List<FavoriteMovie> favMovies) {
        try {
            List<Movie> movies = new ArrayList<>();
            for (FavoriteMovie fm : favMovies) {
                PreparedStatement statement = conn.prepareStatement("select * from movies where id = ?");
                statement.setLong(1, fm.getMovieID());
                ResultSet res = statement.executeQuery();
                if (res.next()) {
                    movies.add(MovieMapping.getMovie(res));
                }
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
