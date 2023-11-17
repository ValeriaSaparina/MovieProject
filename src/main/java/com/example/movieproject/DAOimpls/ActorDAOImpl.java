package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.ActorMapping;
import com.example.movieproject.mappings.DirectorMapping;
import com.example.movieproject.models.Actor;
import com.example.movieproject.models.Director;
import com.example.movieproject.models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActorDAOImpl implements DAO<Actor> {

    private Connection conn;

    public ActorDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();

    }

    @Override
    public void create(Actor obj) {

    }

    @Override
    public Actor get(long id) {
        return null;
    }

    @Override
    public void update(Actor entity) {

    }

    @Override
    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from actors");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                actors.add(ActorMapping.getActor(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actors;
    }

    public List<Actor> getByPattern(String pattern) {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "select * from actors where lower(actors.firstname) like ? or lower(actors.lastname) like ?;");
            statement.setString(1, "%" + pattern + "%");
            statement.setString(2, "%" + pattern + "%");
            ResultSet res = statement.executeQuery();
            List<Actor> actors = new ArrayList<>();
            while (res.next()) {
                actors.add(ActorMapping.getActor(res));
            }
            return actors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
