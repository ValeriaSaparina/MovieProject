package com.example.movieproject.Helpers;

import com.example.movieproject.DAOimpls.UserDAOImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            sce.getServletContext().setAttribute(Params.USER_DAO, new UserDAOImpl());

            sce.getServletContext().setAttribute(Params.USER_SERVICE, new UserService());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
