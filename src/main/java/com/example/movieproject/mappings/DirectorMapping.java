package com.example.movieproject.mappings;

import com.example.movieproject.models.Actor;
import com.example.movieproject.models.Director;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorMapping {
    public static Director getDirector(ResultSet res) throws SQLException {
        return new Director(res.getLong("id"),
                res.getString("firstname"), res.getString("lastname"),
                res.getString("gender"), res.getString("photopath"),
                res.getDate("dateofbirth")
        );
    }
}
