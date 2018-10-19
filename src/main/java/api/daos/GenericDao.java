package api.daos;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID> {

    void save(T entity);

    Optional<T> read(ID id);

    void deleteById(ID id);

    List<T> findAll();

}
