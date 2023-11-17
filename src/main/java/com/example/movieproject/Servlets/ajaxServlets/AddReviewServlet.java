package com.example.movieproject.Servlets.ajaxServlets;

import com.example.movieproject.DAOimpls.ReviewDAOImpl;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.Review;
import com.example.movieproject.models.User;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "addReview", value = "/addReview")
public class AddReviewServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");
        String text = request.getParameter("text");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        int movieId = Integer.parseInt(request.getParameter("movieId"));

        User user = (User) request.getSession().getAttribute(Params.AUTH_SESSION);

        ReviewDAOImpl reviewDAO = (ReviewDAOImpl) request.getServletContext().getAttribute(Params.REVIEW_DAO);
        Review review = new Review(user.getId(), movieId, title, type, text, LocalDate.now(), 0.0);
        reviewDAO.create(review);

        JSONObject jo = new JSONObject();
        jo.put("success", true);
        jo.put("review", review);

        response.getWriter().write(jo.toString());

    }

}
