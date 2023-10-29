package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                return new User(res.getLong("id"), res.getString("username"), res.getString("password"),
                        res.getString("firstname"), res.getString("lastname"),
                        res.getDate("dateofbirth"), res.getString("gender"),
                        res.getString("photopath"), res.getString("bio"));
            } else {
                return null;
            }

            //TODO: заполни все поля
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement statement = conn.prepareStatement("update users set firstname = ?, lastname = ?, gender = ?, bio = ? where username = ?;");
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
//            statement.setDate(3, (Date) user.getDateOfBirth());
            statement.setString(3, user.getGender());
            statement.setString(4, user.getBio());
            statement.setString(5, user.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //TODO: implements update user (photo, Birthday)
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from users");
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                users.add(new User(res.getLong("id"), res.getString("username"), res.getString("password"), res.getString("firstname"), res.getString("lastname")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public int addNewUser(String username, String password, String firstname, String lastname) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
                "insert into users (username, password, firstname, lastname) values (?, ?, ?, ?)");
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, firstname);
        statement.setString(4, lastname);

        return statement.executeUpdate();

    }
}