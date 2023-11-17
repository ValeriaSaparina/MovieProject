package com.example.movieproject.Servlets;

import com.example.movieproject.DAOimpls.FavoriteDAOImpl;
import com.example.movieproject.DAOimpls.MovieDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.Helpers.services.MovieService;
import com.example.movieproject.models.FavoriteMovie;
import com.example.movieproject.models.Movie;
import com.example.movieproject.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "allMovies", value = "/allMovies")
public class AllMoviesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        MovieDAOImpl movieDAO = (MovieDAOImpl) req.getServletContext().getAttribute(Params.MOVIE_DAO);
        MovieService movieService = (MovieService) req.getServletContext().getAttribute(Params.MOVIE_SERVICE);
        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);

        List<FavoriteMovie> favorites = new ArrayList<>();
        try {
            movieService.getFavoriteMovies(user.getId());
        } catch (NullPointerException ignored) {
        }


        List<Movie> movies;
        String q = req.getParameter("q");

        if (q == null) {
            q = "";
            movies = movieDAO.getAll();
        } else {
            q = q.toLowerCase();

            String[] names = new String[3];
            names[0] = "country";
            names[1] = "rating";
            names[2] = "ageLimit";

            String[] values = new String[names.length];
            for (int i = 0; i < values.length; i++) {
                values[i] = req.getParameter(names[i]);
            }
            if (values[0] == null) {
                movies = movieDAO.getByLikePattern(q);
            } else {
                movies = movieDAO.getByParameter(q, names, values);
            }
        }

        HashMap<String, Object> root = new HashMap<>();
        root.put("movies", movies);
        root.put("favorites", favorites);
        root.put("query", q);
        Helper.templateFtl("all_movies.ftl", root, resp, req);

    }
}
