package com.example.movieproject.Servlets;

import com.example.movieproject.DAOimpls.FavoriteDAOImpl;
import com.example.movieproject.DAOimpls.MovieDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.Helpers.services.MovieService;
import com.example.movieproject.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@WebServlet(name = "favoriteMovies", value = "/favoriteMovies")
public class FavoriteMoviesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, Object> root = new HashMap<>();
        MovieService movieService = (MovieService) req.getServletContext().getAttribute(Params.MOVIE_SERVICE);
        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);
        root.put("movies", movieService.getFavoriteMovies(user.getId()));
        Helper.templateFtl("favorite_movies.ftl", root, resp, req);
    }
}
