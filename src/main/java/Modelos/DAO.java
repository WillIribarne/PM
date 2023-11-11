package Modelos;

import java.sql.ResultSet;
import java.util.List;

public interface DAO <E, Z, L>{
    public abstract void create(E e) throws Exception;
    
    //agregar
    public abstract void add(E e) throws Exception;
    
    //actualizar
    public abstract void update(E e) throws Exception;
    
    //borro producto
    public abstract void delete(Z id) throws Exception;
    
    public abstract List<E> getAll() throws Exception;
    public List getProducts(Categoria cat) throws Exception;
    
    public abstract E getBy(E e) throws Exception;
    public abstract int getID(L nombre) throws Exception;
    public E rsRowTo(ResultSet rs)throws Exception;

}
