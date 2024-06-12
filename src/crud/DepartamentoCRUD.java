package crud;

import java.util.ArrayList;
import java.util.List;
import model.Departamento;

/**
 * Implementação do CRUD (Create, Read, Update, Delete) para a entidade Departamento.
 * Implementa a interface ICRUD, que define as operações básicas de um CRUD.
 */
public class DepartamentoCRUD implements ICRUD<Departamento> {
    // Lista que armazena os objetos Departamento
    private List<Departamento> departamentos = new ArrayList<>();

    /**
     * Adiciona um novo departamento à lista.
     * @param departamento O departamento a ser adicionado.
     */
    @Override
    public void adicionar(Departamento departamento) {
        departamentos.add(departamento);
    }

    /**
     * Atualiza um departamento existente na lista.
     * @param departamento O departamento com as novas informações.
     */
    @Override
    public void atualizar(Departamento departamento) {
        // Procura o índice do departamento na lista
        int index = departamentos.indexOf(departamento);
        // Se o departamento existir na lista, atualiza-o
        if (index >= 0) {
            departamentos.set(index, departamento);
        }
    }

    /**
     * Remove um departamento da lista com base no seu ID.
     * @param id O índice do departamento a ser removido.
     */
    @Override
    public void remover(int id) {
        // Verifica se o ID é válido
        if (id >= 0 && id < departamentos.size()) {
            // Remove o departamento na posição especificada pelo ID
            departamentos.remove(id);
        }
    }

    /**
     * Lista todos os departamentos.
     * @return Uma nova lista contendo todos os departamentos.
     */
    @Override
    public List<Departamento> listar() {
        // Retorna uma cópia da lista de departamentos
        return new ArrayList<>(departamentos);
    }

    /**
     * Salva os dados dos departamentos em um arquivo.
     * @param filename O nome do arquivo onde os dados serão salvos.
     * Nota: Este método está deixado em branco, pois não haverá salvamento em arquivo.
     */
    @Override
    public void salvar(String filename) {
        // Método deixado em branco, já que não haverá salvamento em arquivo
    }

    /**
     * Carrega os dados dos departamentos de um arquivo.
     * @param filename O nome do arquivo de onde os dados serão carregados.
     * Nota: Este método está deixado em branco, pois não haverá carregamento de arquivo.
     */
    @Override
    public void carregar(String filename) {
        // Método deixado em branco, já que não haverá carregamento de arquivo
    }

    /**
     * Busca um departamento pelo nome.
     * @param nome O nome do departamento a ser buscado.
     * @return O departamento encontrado ou null se não for encontrado.
     */
    public Departamento buscarPorNome(String nome) {
        // Percorre a lista de departamentos para encontrar um com o nome especificado
        for (Departamento departamento : departamentos) {
            if (departamento.getNome().equals(nome)) {
                return departamento; // Retorna o departamento encontrado
            }
        }
        return null; // Retorna null se nenhum departamento for encontrado
    }
}
