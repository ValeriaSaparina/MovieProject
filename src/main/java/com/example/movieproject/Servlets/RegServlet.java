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
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "reg", value = "/registration")
public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Template tmpl = ConfigSingleton.getConfig().getTemplate("reg.ftl");
            HashMap<String, Object> root = new HashMap<>();
            root.put("req", req);
            tmpl.process(root, resp.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");


        try {
            UserService userService = (UserService) req.getServletContext().getAttribute(Params.USER_SERVICE);
            userService.registration(req, resp);

            Helper.redirect(resp, req, "/");
        } catch (SQLException sqlException) {
            Helper.redirect(resp, req, "/registration");
        }
    }
}
