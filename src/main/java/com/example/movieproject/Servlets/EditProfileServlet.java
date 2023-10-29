package com.example.movieproject.Servlets;

import com.example.movieproject.Connections.ConfigSingleton;
import com.example.movieproject.DAOimpls.UserDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "editProfile", value = "/edit_profile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Template temp = ConfigSingleton.getConfig().getTemplate("edit_profile.ftl");
            HashMap<String, Object> root = new HashMap<>();
            User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);
            root.put("user", user);
            root.put("req", req);
            System.out.println(user.getGender());
            temp.process(root, resp.getWriter());
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        UserDAOImpl userDAO = (UserDAOImpl) req.getServletContext().getAttribute(Params.USER_DAO);
        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String[] dateOfBirth = req.getParameter("dateOfBirth").split(".");
        String gender = req.getParameter("gender");
        String bio = req.getParameter("bio");

        user.setFirstname(firstname);
        user.setLastname(lastname);
//        user.setDateOfBirth(new Date(Integer.parseInt(dateOfBirth[2]), new Calendar.(dateOfBirth[1]), Integer.parseInt(dateOfBirth[0]));
        user.setGender(gender);
        user.setBio(bio);
//        user.setPhotoPath();

        userDAO.update(user);
        Helper.redirect(resp, req, "/profile");
    }
}
