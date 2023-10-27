package Modelos;

import java.util.List;

public interface DAO <E,Z>{
    public abstract void create(E entidad) throws Exception;
    public abstract void add(E entidad) throws Exception;
    public abstract void update() throws Exception;
    public abstract void delete() throws Exception;
    public abstract List<E> getAll() throws Exception;
    public abstract E getById(Z id) throws Exception;
}
