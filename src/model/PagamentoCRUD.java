package model;

import util.Serializacao;

import java.util.ArrayList;
import java.util.List;

public class PagamentoCRUD {
    private List<Pagamento> pagamentos = new ArrayList<>();

    public void adicionar(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void atualizar(Pagamento pagamento) {
        int index = pagamentos.indexOf(pagamento);
        if (index >= 0) {
            pagamentos.set(index, pagamento);
        }
    }

    public void remover(int id) {
        if (id >= 0 && id < pagamentos.size()) {
            pagamentos.remove(id);
        }
    }

    public List<Pagamento> listar() {
        return new ArrayList<>(pagamentos);
    }

    public void salvar(String filename) {
        Serializacao.salvarDados(pagamentos, filename);
    }

    public void carregar(String filename) {
        List<String> dados = Serializacao.carregarDados(filename);
        for (String linha : dados) {
            Pagamento pagamento = Pagamento.fromString(linha);
            pagamentos.add(pagamento);
        }
    }
}
