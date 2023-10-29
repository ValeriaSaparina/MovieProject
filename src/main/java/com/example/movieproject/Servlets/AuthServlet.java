package com.example.movieproject.Servlets;

import com.example.movieproject.Connections.ConfigSingleton;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.Helpers.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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
        response.setCharacterEncoding("UTF-8");

        try {
            Template tmpl = ConfigSingleton.getConfig().getTemplate("auth.ftl");
            HashMap<String, Object> root = new HashMap<>();
            root.put("req", request);
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            UserService userService = (UserService) req.getServletContext().getAttribute(Params.USER_SERVICE);
            if (userService.authorization(req, resp)) {
                Helper.redirect(resp, req, "/");
            } else {
                // TODO: implementation of notifications
                Helper.redirect(resp, req, "/auth");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}