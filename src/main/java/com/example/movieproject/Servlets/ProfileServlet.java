package com.example.movieproject.Servlets;

import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);
        HashMap<String, Object> root = new HashMap<>();
        root.put("user", user);

        Helper.templateFtl("profile.ftl", root, resp, req);
    }

}
