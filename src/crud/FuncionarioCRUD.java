package crud;

import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

/**
 * Implementação do CRUD (Create, Read, Update, Delete) para a entidade Funcionario.
 * Implementa a interface ICRUD, que define as operações básicas de um CRUD.
 */
public class FuncionarioCRUD implements ICRUD<Funcionario> {
    // Lista que armazena os objetos Funcionario
    private List<Funcionario> funcionarios = new ArrayList<>();

    /**
     * Adiciona um novo funcionário à lista.
     * @param funcionario O funcionário a ser adicionado.
     */
    @Override
    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    /**
     * Atualiza um funcionário existente na lista.
     * @param funcionario O funcionário com as novas informações.
     */
    @Override
    public void atualizar(Funcionario funcionario) {
        // Procura o índice do funcionário na lista
        int index = funcionarios.indexOf(funcionario);
        // Se o funcionário existir na lista, atualiza-o
        if (index >= 0) {
            funcionarios.set(index, funcionario);
        }
    }

    /**
     * Remove um funcionário da lista com base no seu ID.
     * @param id O índice do funcionário a ser removido.
     */
    @Override
    public void remover(int id) {
        // Verifica se o ID é válido
        if (id >= 0 && id < funcionarios.size()) {
            // Remove o funcionário na posição especificada pelo ID
            funcionarios.remove(id);
        }
    }

    /**
     * Lista todos os funcionários.
     * @return Uma nova lista contendo todos os funcionários.
     */
    @Override
    public List<Funcionario> listar() {
        // Retorna uma cópia da lista de funcionários
        return new ArrayList<>(funcionarios);
    }

    /**
     * Salva os dados dos funcionários em um arquivo.
     * @param filename O nome do arquivo onde os dados serão salvos.
     * Nota: Este método está deixado em branco, pois não haverá salvamento em arquivo.
     */
    @Override
    public void salvar(String filename) {
        // Método deixado em branco, já que não haverá salvamento em arquivo
    }

    /**
     * Carrega os dados dos funcionários de um arquivo.
     * @param filename O nome do arquivo de onde os dados serão carregados.
     * Nota: Este método está deixado em branco, pois não haverá carregamento de arquivo.
     */
    @Override
    public void carregar(String filename) {
        // Método deixado em branco, já que não haverá carregamento de arquivo
    }
}
