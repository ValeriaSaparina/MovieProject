package com.example.movieproject.Servlets.ajaxServlets;

import com.example.movieproject.DAOimpls.MovieDAOImpl;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.Movie;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "search", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        String query = req.getParameter("query");
        MovieDAOImpl movieDAO = (MovieDAOImpl) req.getServletContext().getAttribute(Params.MOVIE_DAO);
        List<Movie> movies = movieDAO.getByLikePattern(query);

        JSONArray ja = new JSONArray();
        for (Movie movie: movies) {
            ja.put(new JSONObject(movie));
        }
        JSONObject jo = new JSONObject();
        jo.put("objects", ja);
        jo.put("path", req.getContextPath());
        resp.getWriter().write(jo.toString());
    }
}
