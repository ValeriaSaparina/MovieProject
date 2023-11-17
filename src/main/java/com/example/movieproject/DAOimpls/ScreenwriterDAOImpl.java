package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.DirectorMapping;
import com.example.movieproject.mappings.ProducerMapping;
import com.example.movieproject.mappings.ScreenwriterMapping;
import com.example.movieproject.models.Director;
import com.example.movieproject.models.Person;
import com.example.movieproject.models.Producer;
import com.example.movieproject.models.Screenwriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ScreenwriterDAOImpl implements DAO<Screenwriter> {

    private Connection conn;

    public ScreenwriterDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();

    }

    @Override
    public void create(Screenwriter obj) {

    }

    @Override
    public Screenwriter get(long id) {
        return null;
    }

    @Override
    public void update(Screenwriter entity) {

    }

    @Override
    public List<Screenwriter> getAll() {
        List<Screenwriter> screenwriters = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from screenwriters");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                screenwriters.add(ScreenwriterMapping.getScreenwriter(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return screenwriters;
    }

    public List<Screenwriter> getByPattern(String pattern) {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "select * from screenwriters where lower(screenwriters.firstname) like ? or lower(screenwriters.lastname) like ?;");
            statement.setString(1, "%" + pattern + "%");
            statement.setString(2, "%" + pattern + "%");
            ResultSet res = statement.executeQuery();
            List<Screenwriter> screenwriters = new ArrayList<>();
            while (res.next()) {
                screenwriters.add(ScreenwriterMapping.getScreenwriter(res));
            }
            return screenwriters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
