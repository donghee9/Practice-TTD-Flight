package com.example.ttd.infra;

import java.util.List;

public interface PersistRepository<T> {
    void save(T entity);

    void delete(T entity);

    void deleteAll();

    T findById(Long id);

    List<T> findAll();
}
