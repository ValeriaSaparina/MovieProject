package com.example.movieproject.Servlets;

import com.example.movieproject.DAOimpls.FavoriteDAOImpl;
import com.example.movieproject.DAOimpls.MovieDAOImpl;
import com.example.movieproject.DAOimpls.ReviewDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.Helpers.services.MovieService;
import com.example.movieproject.models.FavoriteMovie;
import com.example.movieproject.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "movieCard", value = "/moviecard")
public class MovieCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        MovieDAOImpl movieDAO = (MovieDAOImpl) req.getServletContext().getAttribute(Params.MOVIE_DAO);
        ReviewDAOImpl reviewDAO = (ReviewDAOImpl) req.getServletContext().getAttribute(Params.REVIEW_DAO);
        MovieService movieService = (MovieService) req.getServletContext().getAttribute(Params.MOVIE_SERVICE);

        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);
        List<FavoriteMovie> favorites = new ArrayList<>();
        if (user != null) {
            movieService.getFavoriteMovies(user.getId());
        }

        int id = Integer.parseInt(req.getParameter("MovieId"));

        HashMap<String, Object> root = new HashMap<>();
        root.put("movie", movieDAO.get(id));
        root.put("reviews", reviewDAO.getByMovieID(id));
        if (user != null) root.put("favorites", favorites);
        root.put("user", user);


        Helper.templateFtl("movie_card.ftl", root, resp, req);
    }

}
