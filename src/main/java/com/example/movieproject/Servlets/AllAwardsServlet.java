package com.example.movieproject.Servlets;

import com.example.movieproject.DAOimpls.AwardDAOImpl;
import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "allAwards", value = "/allAwards")
public class AllAwardsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AwardDAOImpl awardDAO = (AwardDAOImpl) req.getServletContext().getAttribute(Params.AWARD_DAO);
        HashMap<String, Object> root = new HashMap<>();
        root.put("awards", awardDAO.getAll());
        Helper.templateFtl("awards.ftl", root, resp, req);
    }
}
