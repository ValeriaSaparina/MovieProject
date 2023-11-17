package com.example.movieproject.Helpers.services;

import com.example.movieproject.DAOimpls.UserDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserService {

    private ServletContext context;
    private UserDAOImpl userDAO;

    public UserService(ServletContext context) {
        this.context = context;
        userDAO = (UserDAOImpl) context.getAttribute(Params.USER_DAO);
    }

    public boolean authorization(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        String username = req.getParameter("username");
        String password = Helper.hashing(req.getParameter("password"));
        String rememberMe = req.getParameter("remember-me");
        User user = userDAO.getByUsername(username);


        if (user != null && user.getPassword().equals(password)) {
            rememberMe(rememberMe, res, user);
            Helper.saveToSession(Params.AUTH_SESSION, user, req);
            return true;
        } else {
            return false;
        }
    }

    public boolean authFromCookie(HttpServletRequest req) {
        User user = userDAO.getByUsername(Helper.checkCookie(req, Params.REMEMBER_COOKIE));
        if (user != null) {
            Helper.saveToSession(Params.AUTH_SESSION, user, req);
        }
        return user != null;
    }

    public boolean isAuth(HttpServletRequest request) {

        if (request.getSession().getAttribute(Params.AUTH_SESSION) != null) {
            return true;
        }
        return (authFromCookie(request));
    }

    public void rememberMe(String rememberMe, HttpServletResponse res, User user) {
        if (rememberMe != null) {
            Helper.saveToCookie(Params.REMEMBER_COOKIE, user.getUsername(), res);
        }
    }

    public void registration(HttpServletRequest req, HttpServletResponse res) throws SQLException {

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = Helper.hashing(req.getParameter("password"));
        String rememberMe = req.getParameter("remember-me");
        String photoPath = "/avatars/img.png";

        User u = new User(username, name, surname, password);
        u.setPhotoPath(photoPath);
        userDAO.addNewUser(username, password, name, surname, photoPath);
        User user = userDAO.getByUsername(username);
        Helper.saveToSession(Params.AUTH_SESSION, user, req);
        rememberMe(rememberMe, res, user);

    }

}
