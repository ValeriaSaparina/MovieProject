package com.example.movieproject.Servlets;

import com.example.movieproject.Connections.ConfigSingleton;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);
        try {
            Template tmpl = ConfigSingleton.getConfig().getTemplate("profile.ftl");
            HashMap<String, Object> root = new HashMap<>();
            root.put("user", user);
            root.put("req", req);
            tmpl.process(root, resp.getWriter());
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
