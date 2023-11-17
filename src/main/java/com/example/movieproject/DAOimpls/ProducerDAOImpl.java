package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.MovieMapping;
import com.example.movieproject.mappings.ProducerMapping;
import com.example.movieproject.models.Movie;
import com.example.movieproject.models.Person;
import com.example.movieproject.models.Producer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProducerDAOImpl implements DAO<Producer> {

    private Connection conn;

    public ProducerDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();
    }

    @Override
    public void create(Producer obj) {

    }

    @Override
    public Producer get(long id) {
        return null;
    }

    @Override
    public void update(Producer entity) {

    }

    @Override
    public List<Producer> getAll() {
        List<Producer> producers = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from producers");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                producers.add(ProducerMapping.getProducer(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    public List<Producer> getByPattern(String pattern) {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "select * from producers where lower(producers.firstname) like ? or lower(producers.lastname) like ?;");
            statement.setString(1, "%" + pattern + "%");
            statement.setString(2, "%" + pattern + "%");
            ResultSet res = statement.executeQuery();
            List<Producer> producers = new ArrayList<>();
            while (res.next()) {
                producers.add(ProducerMapping.getProducer(res));
            }
            return producers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
