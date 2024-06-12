package crud;

import java.util.List;

/**
 * Interface que define as operações básicas de um CRUD (Create, Read, Update, Delete).
 * @param <T> O tipo de objeto que será manipulado pelo CRUD.
 */
public interface ICRUD<T> {

    /**
     * Adiciona um novo objeto à coleção.
     * @param t O objeto a ser adicionado.
     */
    void adicionar(T t);

    /**
     * Atualiza um objeto existente na coleção.
     * @param t O objeto com as novas informações.
     */
    void atualizar(T t);

    /**
     * Remove um objeto da coleção com base no seu ID.
     * @param id O índice do objeto a ser removido.
     */
    void remover(int id);

    /**
     * Lista todos os objetos da coleção.
     * @return Uma lista contendo todos os objetos.
     */
    List<T> listar();

    /**
     * Salva os dados da coleção em um arquivo.
     * @param filename O nome do arquivo onde os dados serão salvos.
     */
    void salvar(String filename);

    /**
     * Carrega os dados da coleção de um arquivo.
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    void carregar(String filename);
}
