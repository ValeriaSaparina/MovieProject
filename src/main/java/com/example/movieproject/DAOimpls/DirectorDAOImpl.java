package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.ActorMapping;
import com.example.movieproject.mappings.DirectorMapping;
import com.example.movieproject.mappings.MovieMapping;
import com.example.movieproject.models.Director;
import com.example.movieproject.models.Movie;
import com.example.movieproject.models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DirectorDAOImpl implements DAO<Director> {

    private Connection conn;

    public DirectorDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();

    }

    @Override
    public void create(Director obj) {

    }

    @Override
    public Director get(long id) {
        return null;
    }

    @Override
    public void update(Director entity) {

    }

    @Override
    public List<Director> getAll() {
        List<Director> directors = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from directors");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                directors.add(DirectorMapping.getDirector(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return directors;
    }

    public List<Director> getByPattern(String pattern) {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "select * from directors where lower(directors.firstname) like ? or lower(directors.lastname) like ?;");
            statement.setString(1, "%" + pattern + "%");
            statement.setString(2, "%" + pattern + "%");
            ResultSet res = statement.executeQuery();
            List<Director> directors = new ArrayList<>();
            while (res.next()) {
                directors.add(DirectorMapping.getDirector(res));
            }
            return directors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
