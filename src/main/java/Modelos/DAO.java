package Modelos;

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
    public List getProducts(Categoria cat);
    
    public abstract E getById(Z id) throws Exception;
    public E getUsuario(L nombre);
    
    
}
