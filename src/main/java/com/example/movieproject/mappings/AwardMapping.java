package com.example.movieproject.mappings;

import com.example.movieproject.models.Award;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AwardMapping {

    public static Award getAward(ResultSet res) throws SQLException {
        return new Award(res.getLong("id"), res.getString("award_name"),
                res.getString("award_category"), res.getDate("date_foundation"), res.getString("awarded_location"),
                res.getString("history"), res.getString("founder"), res.getString("other_details"));

    }
}
