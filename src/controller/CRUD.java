package controller;

import java.util.List;

public interface CRUD<T> {
    void cadastrar(T obj);
    void alterar(T obj);
    void deletar(int id);
    List<T> listar();
}
