package api.daos.memory;

import api.daos.GenericDao;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class GenericDaoMemory<T> implements GenericDao<T, String> {

    private Map<String, T> map;

    private int id;

    GenericDaoMemory(Map<String, T> map) {
        this.map = map;
        this.id = 1;
    }

    @Override
    public void save(T entity) {
        String id = this.getId(entity);
        if (id == null) {
            id = String.valueOf(this.id++);
            this.setId(entity, String.valueOf(id));
        }
        this.map.put(id, entity);
        LogManager.getLogger(this.getClass()).debug("   save: " + entity);
    }

    @Override
    public Optional<T> read(String id) {
        T entity = map.get(id);
        LogManager.getLogger(this.getClass()).debug("   read(" + id + "): " + entity);
        return (entity == null) ? Optional.empty() : Optional.of(entity);
    }

    @Override
    public void deleteById(String id) {
        LogManager.getLogger(this.getClass()).debug("   deleteById(" + id + "): " + map.remove(id));
    }

    @Override
    public List<T> findAll() {
        ArrayList<T> list = new ArrayList<>(map.values());
        LogManager.getLogger(this.getClass()).debug("   findAll: " + list);
        return list;
    }

    public abstract String getId(T entity);

    public abstract void setId(T entity, String id);

}
