package com.example.movieproject.mappings;

import com.example.movieproject.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapping {
    public static Person getPerson(ResultSet res) throws SQLException {
        return new Person(res.getLong("id"),
                res.getString("firstname"), res.getString("lastname"),
                res.getString("gender"), res.getString("photopath"),
                res.getDate("dateofbirth")
        );
    }
}
