package com.example.movieproject.Helpers;

import com.example.movieproject.DAOimpls.UserDAOImpl;
import com.example.movieproject.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserService {

    public boolean authorization(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        UserDAOImpl userDAO = (UserDAOImpl) req.getServletContext().getAttribute(Params.USER_DAO);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("remember-me");
        User user = userDAO.getByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            rememberMe(rememberMe, res, req, user);
            return true;
        } else {
            return false;
        }
    }

    public void rememberMe(String rememberMe, HttpServletResponse res, HttpServletRequest req, User user) {
        if (rememberMe != null) {
            Helper.saveToCookie(Params.REMEMBER_COOKIE, "true", res);
        } else {
            Helper.saveToSession(Params.AUTH_SESSION, user, req);
        }
    }

    public void registration(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        UserDAOImpl userDAO = (UserDAOImpl) req.getServletContext().getAttribute(Params.USER_DAO);

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("remember-me");


        int count = userDAO.addNewUser(username, password, name, surname);
        System.out.println(count);
        User user = userDAO.getByUsername(username);
        rememberMe(rememberMe, res, req, user);

    }

}
