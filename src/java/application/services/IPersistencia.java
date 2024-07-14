package java.application.services;

import java.util.List;

public interface IPersistencia<T> {
    void crear(T entidad);
    T leer(int id);
    List<T> leerTodos();
    void actualizar(T entidad);
    void eliminar(int id);
}
