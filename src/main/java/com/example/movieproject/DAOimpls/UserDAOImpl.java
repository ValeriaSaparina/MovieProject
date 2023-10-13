package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements DAO<User> {

    Connection conn;

    public UserDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();
    }

    @Override
    public void create(User obj) {

    }

    @Override
    public User get(long id) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from users where id = ?");
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                User u = new User(res.getString(2), res.getString(3));
                return u;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public User getByUsername(String username) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from users where username = ?");
            statement.setString(1, username);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return new User(res.getString(2), res.getString(3));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void update(long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public int addNewUser(String username, String password, String name, String surname) throws SQLException {
            PreparedStatement statement = conn.prepareStatement(
                    "insert into users (username, password, name, surname) values (?, ?, ?, ?)");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(4, surname);
            return statement.executeUpdate();

    }
}