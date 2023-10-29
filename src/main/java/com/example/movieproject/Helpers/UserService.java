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
            rememberMe(rememberMe, res, user);
            Helper.saveToSession(Params.AUTH_SESSION, user, req);
            return true;
        } else {
            return false;
        }
    }

    public boolean authFromCookie(HttpServletRequest req, String username) {
        User user = ((UserDAOImpl) req.getServletContext().getAttribute(Params.USER_DAO)).getByUsername(username);
        if (user != null) {
            Helper.saveToSession(Params.AUTH_SESSION, user, req);
        }
        return user != null;
    }

    public boolean isAuth(HttpServletRequest request) {

        if (request.getSession().getAttribute(Params.AUTH_SESSION) != null) {
            return true;
        } else {
            String username = Helper.checkCookie(request, Params.REMEMBER_COOKIE);
            if (username != null) {
                authFromCookie(request, username);
                return true;
            }
        }
        return false;
    }

    public void rememberMe(String rememberMe, HttpServletResponse res, User user) {
        if (rememberMe != null) {
            Helper.saveToCookie(Params.REMEMBER_COOKIE, user.getUsername(), res);
        }
    }

    public void registration(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        UserDAOImpl userDAO = (UserDAOImpl) req.getServletContext().getAttribute(Params.USER_DAO);

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("remember-me");

        userDAO.addNewUser(username, password, name, surname);
        User user = userDAO.getByUsername(username);
        Helper.saveToSession(Params.AUTH_SESSION, user, req);
        rememberMe(rememberMe, res, user);

    }

}
