package db.interfaces;

import java.util.List;

public interface IBaseDao<T> {

    void save(T entity);
    T getByID(int id);
    void update(T entity);
    void deleteByID(int id);
    List<T> getAll();
}
