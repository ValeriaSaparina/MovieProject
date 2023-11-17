package com.example.movieproject.Servlets;

import com.example.movieproject.Helpers.Helper;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.Helpers.services.PersonService;
import com.example.movieproject.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "allPersons", value = "/allPersons")
public class AllPersonsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String q = req.getParameter("q");
        if (q != null) {
            q = q.toLowerCase();
        } else {
            q = "";
        }
        String person = req.getParameter("role");
        List<? extends Person> persons;

        PersonService personService = (PersonService) req.getServletContext().getAttribute(Params.PERSON_SERVICE);

        if (person == null) {
            persons = (q == null) ? personService.getAll() : personService.getByPattern(q.toLowerCase());
        } else {
            persons = personService.getByTypePerson(q, person);
        }



        HashMap<String, Object> root = new HashMap<>();
        root.put("persons", persons);
        root.put("query", q);
        Helper.templateFtl("all_persons.ftl", root, resp, req);
    }
}
