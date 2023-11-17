package com.example.movieproject.Helpers.services;

import com.example.movieproject.DAOimpls.FavoriteDAOImpl;
import com.example.movieproject.DAOimpls.MovieDAOImpl;
import com.example.movieproject.DAOimpls.ReviewDAOImpl;
import com.example.movieproject.Helpers.Params;
import com.example.movieproject.models.FavoriteMovie;
import com.example.movieproject.models.Movie;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MovieService {

    ReviewDAOImpl reviewDAO;
    MovieDAOImpl movieDAO;
    FavoriteDAOImpl favoriteDAO;
    ReviewService reviewService;
    private ServletContext context;

    public MovieService(ServletContext context) {
        this.context = context;
        this.movieDAO = (MovieDAOImpl) context.getAttribute(Params.MOVIE_DAO);
        this.favoriteDAO = (FavoriteDAOImpl) context.getAttribute(Params.FAVORITE_DAO);
        this.reviewDAO = (ReviewDAOImpl) context.getAttribute(Params.REVIEW_DAO);
    }

    public List<Movie> getTheMostDiscussedMovies(int count) {
        reviewService = (ReviewService) context.getAttribute(Params.REVIEW_SERVICE);

        List<Movie> movies = new ArrayList<>();


        Set<Long> movieIDs = reviewService.reverseOrderSort(reviewDAO.getAll()).keySet();
        int i = 0;
        Iterator<Long> iterator = movieIDs.iterator();
        while (iterator.hasNext() && i < count) {
            movies.add(movieDAO.get(iterator.next()));
            i++;
        }
        return movies;
    }

    public List<Movie> getTheMostExpectedMovies(int top) {
        String query = "SELECT * FROM movies WHERE releaseworld > CURRENT_DATE ORDER BY rating DESC LIMIT " + top + ";";
        return movieDAO.getByQuery(query);
    }

    public List<Movie> getTheTop(int top) {
        String query = "SELECT * FROM movies WHERE movies.releaseworld <= CURRENT_DATE ORDER BY rating DESC LIMIT " + top + ";";
        return movieDAO.getByQuery(query);
    }

    public List<Movie> getFavoriteMovies(long userId) {
        List<FavoriteMovie> favMovies = favoriteDAO.getByUserId(userId);

        return movieDAO.getMoviesByList(favMovies);
    }
}
