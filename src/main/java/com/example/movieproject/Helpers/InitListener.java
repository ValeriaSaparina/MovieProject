package com.example.movieproject.Helpers;

import com.example.movieproject.Connections.ConfigSingleton;
import com.example.movieproject.DAOimpls.*;
import com.example.movieproject.Helpers.services.MovieService;
import com.example.movieproject.Helpers.services.PersonService;
import com.example.movieproject.Helpers.services.ReviewService;
import com.example.movieproject.Helpers.services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();

        context.setRequestCharacterEncoding(Params.ENCODING);
        context.setResponseCharacterEncoding(Params.ENCODING);

        try {
            ConfigSingleton.setServletContext(sce.getServletContext());

            context.setAttribute(Params.USER_DAO, new UserDAOImpl());
            context.setAttribute(Params.MOVIE_DAO, new MovieDAOImpl());
            context.setAttribute(Params.FAVORITE_DAO, new FavoriteDAOImpl());
            context.setAttribute(Params.REVIEW_DAO, new ReviewDAOImpl());
            context.setAttribute(Params.ACTOR_DAO, new ActorDAOImpl());
            context.setAttribute(Params.PRODUCER_DAO, new ProducerDAOImpl());
            context.setAttribute(Params.SCREENWRITER_DAO, new ScreenwriterDAOImpl());
            context.setAttribute(Params.DIRECTOR_DAO, new DirectorDAOImpl());
            context.setAttribute(Params.AWARD_DAO, new AwardDAOImpl());

            context.setAttribute(Params.USER_SERVICE, new UserService(context));
            context.setAttribute(Params.REVIEW_SERVICE, new ReviewService(context));
            context.setAttribute(Params.MOVIE_SERVICE, new MovieService(context));
            context.setAttribute(Params.MOVIE_SERVICE, new MovieService(context));
            context.setAttribute(Params.PERSON_SERVICE, new PersonService(context));
            context.setAttribute(Params.HELPER, new Helper());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
