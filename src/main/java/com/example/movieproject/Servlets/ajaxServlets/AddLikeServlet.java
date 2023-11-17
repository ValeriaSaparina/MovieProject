package com.example.movieproject.Servlets.ajaxServlets;

import com.example.movieproject.DAOimpls.FavoriteDAOImpl;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.FavoriteMovie;
import com.example.movieproject.models.User;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addLike", value = "/addLike")
public class AddLikeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        long movieId = Long.parseLong(req.getParameter("movieId"));
        long userId = ((User) req.getSession().getAttribute(Params.AUTH_SESSION)).getId();

        FavoriteDAOImpl favoriteDAO = (FavoriteDAOImpl) req.getServletContext().getAttribute(Params.FAVORITE_DAO);
        favoriteDAO.create(new FavoriteMovie(movieId, userId));
        JSONObject jo = new JSONObject();
        jo.put("success", true);
        resp.getWriter().write(jo.toString());
    }
}
