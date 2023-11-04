package com.example.movieproject.mappings;

import com.example.movieproject.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapping {
    public static User getUser(ResultSet res) throws SQLException {
        return new User(res.getLong("id"), res.getString("username"), res.getString("password"),
                res.getString("firstname"), res.getString("lastname"),
                res.getDate("dateofbirth"), res.getString("gender"),
                res.getString("photopath"), res.getString("bio"));
    }
}
