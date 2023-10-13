package com.example.movieproject.Filters;

import com.example.movieproject.Helpers.Helper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (!Helper.isAuth(req)) {
            chain.doFilter(req, res);
        } else {
            Helper.redirect(res, req, "/");
        }

    }
}
