package com.example.movieproject.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/movieproject";
    private static final String USER = "postgres";
    private static final String PASS = "20112003";
    //    private static Statement statement;
    private static Connection conn;

    private static void connection() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            statement = conn.createStatement();
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

//    public static Statement getStatement() {
//        if (statement == null) {
//            connection();
//        }
//        return statement;
//    }

    public static Connection getConn() {
        if (conn == null) {
            connection();
        }
        return conn;
    }

}
