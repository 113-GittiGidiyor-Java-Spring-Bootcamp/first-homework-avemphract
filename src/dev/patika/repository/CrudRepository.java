package dev.patika.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findById(int id);
    boolean saveToDatabase(T object);
    boolean deleteFromDatabase(T object);
    boolean deleteFromDatabase(int id);
    void update(T object);
}
