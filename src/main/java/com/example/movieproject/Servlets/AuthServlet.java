package com.example.movieproject.Servlets;

import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.Helpers.services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "auth", value = "/auth")
public class AuthServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        HashMap<String, Object> root = new HashMap<>();
        Helper.templateFtl("auth.ftl", root, response, request);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = (UserService) req.getServletContext().getAttribute(Params.USER_SERVICE);
        try {
            if (userService.authorization(req, resp)) {
                Helper.redirect(resp, req, "/");
            } else {
                Helper.redirect(resp, req, "/auth");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}