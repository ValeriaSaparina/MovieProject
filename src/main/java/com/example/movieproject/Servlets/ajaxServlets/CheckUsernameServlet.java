package com.example.movieproject.Servlets.ajaxServlets;

import com.example.movieproject.DAOimpls.UserDAOImpl;
import com.example.movieproject.Helpers.Params;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkUsername", value = "/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        String username = req.getParameter("username");
        UserDAOImpl userDAO = (UserDAOImpl) req.getServletContext().getAttribute(Params.USER_DAO);
        Boolean isUnique = userDAO.getByUsername(username) == null;
        JSONObject jo = new JSONObject();
        jo.put("isUnique", isUnique);
        resp.getWriter().write(jo.toString());
    }
}
