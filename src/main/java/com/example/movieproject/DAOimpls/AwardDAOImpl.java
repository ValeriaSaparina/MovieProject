package com.example.movieproject.DAOimpls;

import com.example.movieproject.Connections.JDBCConnection;
import com.example.movieproject.DAO.DAO;
import com.example.movieproject.mappings.AwardMapping;
import com.example.movieproject.models.Award;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AwardDAOImpl implements DAO<Award> {

    Connection conn;

    public AwardDAOImpl() throws SQLException {
        conn = JDBCConnection.getConn();
    }

    @Override
    public void create(Award obj) {

    }

    @Override
    public Award get(long id) {
        return null;
    }

    @Override
    public void update(Award entity) {

    }

    @Override
    public List<Award> getAll() {
        List<Award> awards = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("select * from awards order by award_name");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                awards.add(AwardMapping.getAward(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return awards;
    }
}
