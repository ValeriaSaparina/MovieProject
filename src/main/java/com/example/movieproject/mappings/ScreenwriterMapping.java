package com.example.movieproject.mappings;

import com.example.movieproject.models.Screenwriter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScreenwriterMapping {
    public static Screenwriter getScreenwriter(ResultSet res) throws SQLException {
        return new Screenwriter(res.getLong("id"),
                res.getString("firstname"), res.getString("lastname"),
                res.getString("gender"), res.getString("photopath"),
                res.getDate("dateofbirth")
        );
    }
}
