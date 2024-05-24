package Presencial.dao;

public interface iDao<T> {
    //metodos abstractos, en el caso de tener atributos deben estar como constantes.
    //el famoso CRUD o ABM
    T guardar(T t);
    T buscar(Integer id);
}
