package com.example.movieproject.Servlets.ajaxServlets;

import com.example.movieproject.DAOimpls.FavoriteDAOImpl;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.FavoriteMovie;
import com.example.movieproject.models.User;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteLike", value = "/deleteLike")
public class DeleteLikeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        long movieId = Long.parseLong(req.getParameter("movieId"));

        FavoriteMovie favoriteMovie = new FavoriteMovie(movieId, ((User) req.getSession().getAttribute(Params.AUTH_SESSION)).getId());
        FavoriteDAOImpl favoriteDAO = (FavoriteDAOImpl) req.getServletContext().getAttribute(Params.FAVORITE_DAO);
        favoriteDAO.delete(favoriteMovie);
        JSONObject jo = new JSONObject();
        jo.put("success", true);
        resp.getWriter().write(jo.toString());
    }
}
