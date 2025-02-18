package Controller;

import java.util.List;

/**
 * Controller interface for CRUD functionalities
 *
 * @param <T> Object type
 * @param <ID> Object identification parameter type
 */
public interface IController<T, ID> {
    void add(T entity);
    void delete(ID entity);
    void update(T entity1, T entity2);
    T get(ID entity);
    List<T> getAll();
}
