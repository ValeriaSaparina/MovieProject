package com.example.movieproject.Helpers;

import com.example.movieproject.Connections.ConfigSingleton;
import com.example.movieproject.DAOimpls.MovieDAOImpl;
import com.example.movieproject.DAOimpls.UserDAOImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        sce.getServletContext().setRequestCharacterEncoding(Params.ENCODING);
        sce.getServletContext().setResponseCharacterEncoding(Params.ENCODING);

        try {
            ConfigSingleton.setServletContext(sce.getServletContext());

            sce.getServletContext().setAttribute(Params.USER_DAO, new UserDAOImpl());
            sce.getServletContext().setAttribute(Params.MOVIE_DAO, new MovieDAOImpl());

            sce.getServletContext().setAttribute(Params.USER_SERVICE, new UserService());
            //TODO: add Helper to context
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
