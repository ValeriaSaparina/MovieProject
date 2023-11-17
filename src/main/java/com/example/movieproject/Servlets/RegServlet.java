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

@WebServlet(name = "reg", value = "/registration")
public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        HashMap<String, Object> root = new HashMap<>();
        Helper.templateFtl("reg.ftl", root, resp, req);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        try {
            UserService userService = (UserService) req.getServletContext().getAttribute(Params.USER_SERVICE);
            userService.registration(req, resp);

            Helper.redirect(resp, req, "/");
        } catch (SQLException sqlException) {
            Helper.redirect(resp, req, "/registration");
        }
    }
}
