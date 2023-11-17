package com.example.movieproject.Helpers;

import com.example.movieproject.Connections.ConfigSingleton;
import com.example.movieproject.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;

public class Helper {

    public static boolean isAuth(HttpServletRequest request) {

        return request.getSession().getAttribute(Params.AUTH_SESSION) != null ||
                Helper.checkCookie(request, Params.REMEMBER_COOKIE) != null;
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
    }

    public static void templateFtl(String template, HashMap<String, Object> root, HttpServletResponse resp, HttpServletRequest req) {
        //TODO: rename it, pls
        try {
            Template tmpl = ConfigSingleton.getConfig().getTemplate(template);

            root.put("path", req.getContextPath());
            root.put("isAuth", isAuth(req));

            tmpl.process(root, resp.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hashing(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Params.ALGORITHM);
            str += Params.SALT;
            byte[] digest = messageDigest.digest(str.getBytes());
            String res = Base64.getEncoder().encodeToString(digest);
            return res;
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

}
