package com.example.movieproject.Servlets;

import com.example.movieproject.DAOimpls.UserDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "editProfile", value = "/edit_profile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        HashMap<String, Object> root = new HashMap<>();
        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);
        root.put("user", user);
        Helper.templateFtl("edit_profile.ftl", root, resp, req);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        UserDAOImpl userDAO = (UserDAOImpl) req.getServletContext().getAttribute(Params.USER_DAO);
        User user = (User) req.getSession().getAttribute(Params.AUTH_SESSION);
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        Date dateOfBirth;
        try {
            dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        } catch (IllegalArgumentException e) {
            dateOfBirth = user.getDateOfBirth();
        }
        String gender = req.getParameter("gender");
        String bio = req.getParameter("bio");

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setDateOfBirth(dateOfBirth);
        user.setGender(gender);
        user.setBio(bio);

        Part p = req.getPart("photo");
        if (p.getSize() != 0) {
            String localdir = "uploads";
            String pathDir = getServletContext().getRealPath("") + File.separator + localdir;
            File dir = new File(pathDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String[] filename_data = p.getSubmittedFileName().split("\\.");
            String filename = Math.random() + "." + filename_data[filename_data.length - 1];
            String fullpath = pathDir + File.separator + filename;
            p.write(fullpath);
            user.setPhotoPath("/" + localdir + "/" + filename);
        }

        userDAO.update(user);
        Helper.redirect(resp, req, "/profile");
    }
}
