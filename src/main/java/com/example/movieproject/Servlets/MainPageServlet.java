package com.example.movieproject.Servlets;

import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.Helpers.services.MovieService;
import com.example.movieproject.models.Movie;
import com.example.movieproject.models.User;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "mainPage", value = "/")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext ctx = req.getServletContext();
        MovieService movieService = (MovieService) ctx.getAttribute(Params.MOVIE_SERVICE);

        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);

        List<Movie> topDiscussed = movieService.getTheMostDiscussedMovies(Params.TOP);
        List<Movie> topExpected = movieService.getTheMostExpectedMovies(Params.TOP);
        List<Movie> top = movieService.getTheTop(Params.TOP);


        HashMap<String, Object> root = new HashMap<>();
        root.put("topDiscussed", topDiscussed);
        root.put("top", top);
        root.put("topExpected", topExpected);
        if (user!= null) {
            List<Movie> favorites = movieService.getFavoriteMovies(user.getId());
            root.put("favorites", favorites);
        }

//        if (user != null) {
//            root.put("user", req.getSession().getAttribute(Params.AUTH_SESSION));
//        }
        Helper.templateFtl("main_page.ftl", root, resp, req);
    }
}
