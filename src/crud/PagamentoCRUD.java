package crud;

import util.Serializacao;
import java.util.ArrayList;
import java.util.List;
import model.Pagamento;

/**
 * Implementação do CRUD (Create, Read, Update, Delete) para a entidade Pagamento.
 * Implementa a interface ICRUD, que define as operações básicas de um CRUD.
 */
public class PagamentoCRUD implements ICRUD<Pagamento> {
    // Lista que armazena os objetos Pagamento
    private List<Pagamento> pagamentos = new ArrayList<>();

    /**
     * Adiciona um novo pagamento à lista.
     * @param pagamento O pagamento a ser adicionado.
     */
    @Override
    public void adicionar(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    /**
     * Atualiza um pagamento existente na lista.
     * @param pagamento O pagamento com as novas informações.
     */
    @Override
    public void atualizar(Pagamento pagamento) {
        // Procura o índice do pagamento na lista
        int index = pagamentos.indexOf(pagamento);
        // Se o pagamento existir na lista, atualiza-o
        if (index >= 0) {
            pagamentos.set(index, pagamento);
        }
    }

    /**
     * Remove um pagamento da lista com base no seu ID.
     * @param id O índice do pagamento a ser removido.
     */
    @Override
    public void remover(int id) {
        // Busca o pagamento pelo ID
        Pagamento pagamento = buscarPorId(id);
        // Se o pagamento for encontrado, remove-o
        if (pagamento != null) {
            pagamentos.remove(pagamento);
        }
    }

    /**
     * Lista todos os pagamentos.
     * @return Uma nova lista contendo todos os pagamentos.
     */
    @Override
    public List<Pagamento> listar() {
        // Retorna uma cópia da lista de pagamentos
        return new ArrayList<>(pagamentos);
    }

    /**
     * Salva os dados dos pagamentos em um arquivo.
     * @param filename O nome do arquivo onde os dados serão salvos.
     */
    @Override
    public void salvar(String filename) {
        Serializacao.salvarDados(pagamentos, filename);
    }

    /**
     * Carrega os dados dos pagamentos de um arquivo.
     * @param filename O nome do arquivo de onde os dados serão carregados.
     */
    @Override
    public void carregar(String filename) {
        List<String> dados = Serializacao.carregarDados(filename);
        for (String linha : dados) {
            Pagamento pagamento = Pagamento.fromString(linha);
            pagamentos.add(pagamento);
        }
        // Atualizar o contador para o próximo ID
        if (!pagamentos.isEmpty()) {
            Pagamento.setContador(pagamentos.get(pagamentos.size() - 1).getId() + 1);
        }
    }

    /**
     * Busca um pagamento pelo ID.
     * @param id O ID do pagamento a ser buscado.
     * @return O pagamento encontrado ou null se não for encontrado.
     */
    public Pagamento buscarPorId(int id) {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getId() == id) {
                return pagamento; // Retorna o pagamento encontrado
            }
        }
        return null; // Retorna null se nenhum pagamento for encontrado
    }
}
