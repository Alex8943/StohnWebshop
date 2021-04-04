package com.example.demo.Repoitory;

import java.util.List;

public interface ICRUD<T> {
    void create(T t);
    List<T> readAll();
    T getContact(long id);
    void update(T t);
    void delete(long id);
}
