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

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            Template tmpl = ConfigSingleton.getConfig().getTemplate("auth.ftl");
            HashMap<String, Object> root = new HashMap<>();
            tmpl.process(root, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            System.out.println("HIIII");
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