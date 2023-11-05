package com.example.movieproject.Servlets;

import com.example.movieproject.DAOimpls.MovieDAOImpl;
import com.example.movieproject.DAOimpls.ReviewDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.Movie;
import com.example.movieproject.models.Review;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "movieCard", value = "/moviecard")
public class MovieCardServlet extends HttpServlet {

    private Movie movie;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        MovieDAOImpl movieDAO = (MovieDAOImpl) req.getServletContext().getAttribute(Params.MOVIE_DAO);
        ReviewDAOImpl reviewDAO = (ReviewDAOImpl) req.getServletContext().getAttribute(Params.REVIEW_DAO);

        String idStr = req.getParameter("MovieId");
        int id = Integer.parseInt(idStr);

        //TODO: норм айдишник сделай (сначасла надо добавить общий список киношек

        List<Movie> movies = movieDAO.getAll();

        movie = movieDAO.get(id);

        List<Review> allReviews = reviewDAO.getByMovieID(id);
        HashMap<String, Object> root = new HashMap<>();
        root.put("req", req);
        root.put("movie", movie);
        root.put("reviews", allReviews);

        Helper.templateFtl("movie_card.ftl", root, resp);
    }

}
