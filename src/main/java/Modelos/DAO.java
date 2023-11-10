package Modelos;

import java.util.List;

public interface DAO <E,Z>{
    public abstract void create(E entidad) throws Exception;
    
    //agregar
    public abstract void add(Object o) throws Exception;
    
    //actualizar
    public abstract void update(Producto producto) throws Exception;
    
    //borro producto
    public abstract void delete(int id) throws Exception;
    
    public abstract List<E> getAll() throws Exception;
    public List getProducts(Categoria cat);
    
    public abstract E getById(Z id) throws Exception;
    public Usuario getUsuario(String nombre);
    
    
}
