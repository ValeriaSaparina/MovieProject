package com.example.movieproject.DAO;

import java.util.List;

public interface DAO<T> {

    void create(T obj);
    T get(long id);
    void update(T entity);
    List<T> getAll();

}