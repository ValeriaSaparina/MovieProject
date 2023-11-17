package com.example.movieproject.mappings;

import com.example.movieproject.models.Actor;
import com.example.movieproject.models.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapping {
    public static Actor getActor(ResultSet res) throws SQLException {
        return new Actor(res.getLong("id"),
                res.getString("firstname"), res.getString("lastname"),
                res.getString("gender"), res.getString("photopath"),
                res.getDate("dateofbirth")
        );
    }
}
