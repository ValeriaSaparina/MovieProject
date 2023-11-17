package com.example.movieproject.mappings;

import com.example.movieproject.models.Person;
import com.example.movieproject.models.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProducerMapping extends PersonMapping {
    public static Producer getProducer(ResultSet res) throws SQLException {
        return new Producer(res.getLong("id"),
                res.getString("firstname"), res.getString("lastname"),
                res.getString("gender"), res.getString("photopath"),
                res.getDate("dateofbirth")
        );
    }
}
