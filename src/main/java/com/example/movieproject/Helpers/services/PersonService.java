package com.example.movieproject.Helpers.services;

import com.example.movieproject.DAOimpls.ActorDAOImpl;
import com.example.movieproject.DAOimpls.DirectorDAOImpl;
import com.example.movieproject.DAOimpls.ProducerDAOImpl;
import com.example.movieproject.DAOimpls.ScreenwriterDAOImpl;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.Person;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private ServletContext context;
    private ProducerDAOImpl producerDAO;
    private ActorDAOImpl actorDAO;
    private DirectorDAOImpl directorDAO;
    private ScreenwriterDAOImpl screenwriterDAO;

    public PersonService(ServletContext context) {
        this.context = context;
        this.producerDAO = (ProducerDAOImpl) context.getAttribute(Params.PRODUCER_DAO);
        this.actorDAO = (ActorDAOImpl) context.getAttribute(Params.ACTOR_DAO);
        this.directorDAO = (DirectorDAOImpl) context.getAttribute(Params.DIRECTOR_DAO);
        this.screenwriterDAO = (ScreenwriterDAOImpl) context.getAttribute(Params.SCREENWRITER_DAO);
    }

    public List<Person> getAll() {
        List<Person> res = new ArrayList<>();
        res.addAll(producerDAO.getAll());
        res.addAll(screenwriterDAO.getAll());
        res.addAll(directorDAO.getAll());
        res.addAll(actorDAO.getAll());
        return res;
    }

    public List<Person> getByPattern(String query) {
        List<Person> res = new ArrayList<>();
        res.addAll(producerDAO.getByPattern(query));
        res.addAll(screenwriterDAO.getByPattern(query));
        res.addAll(directorDAO.getByPattern(query));
        res.addAll(actorDAO.getByPattern(query));
        return res;
    }

    public List<? extends Person> getByTypePerson(String q, String person) {
        List<Person> res = new ArrayList<>();
        if (person.equals("director")) {
            return directorDAO.getByPattern(q);
        }
        if (person.equals("producer")) {
            return producerDAO.getByPattern(q);
        }
        if (person.equals("screenwriter")) {
            return screenwriterDAO.getByPattern(q);
        }
        return actorDAO.getByPattern(q);
    }
}
