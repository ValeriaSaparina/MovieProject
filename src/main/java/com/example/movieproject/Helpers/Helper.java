package com.example.movieproject.Helpers;

import com.example.movieproject.models.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Helper {

    public static boolean isAuth(HttpServletRequest request) {

        return Helper.checkCookie(request, Params.REMEMBER_COOKIE) != null ||
                request.getSession().getAttribute(Params.AUTH_SESSION) != null;
    }

    public static String checkCookie(HttpServletRequest request, String nameCookie) {
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals(nameCookie)) return c.getValue();
            }
        } catch (NullPointerException ignored) {}
        return null;
    }

    public static void saveToCookie(String tag, String value, HttpServletResponse res) {
        res.addCookie(new Cookie(tag, value));
    }

    public static void redirect(HttpServletResponse res, HttpServletRequest req, String path) throws IOException {
        res.sendRedirect(req.getContextPath() + path);
    }

    public static void saveToSession(String auth, User user, HttpServletRequest req) {
        req.getSession().setAttribute(auth, user);
        System.out.println(req.getSession().getAttribute(auth));
    }
}
