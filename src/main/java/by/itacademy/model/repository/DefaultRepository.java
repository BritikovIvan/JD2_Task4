package by.itacademy.model.repository;

import java.util.List;
import java.util.Optional;

public interface DefaultRepository<T> {
    void save(T entity);

    Optional<T> findById(Long id);

    List<T> findAll();

    void delete(Long id);

    void update(T entity);
}
