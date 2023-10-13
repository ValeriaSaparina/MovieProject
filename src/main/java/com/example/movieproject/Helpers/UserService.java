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
            if (rememberMe != null) {
                Helper.saveToCookie(Params.REMEMBER_COOKIE, "true", res);
            } else {
                Helper.saveToSession(Params.AUTH_SESSION, user, req);
            }
            return true;
        } else {
            return false;
        }
    }

}
