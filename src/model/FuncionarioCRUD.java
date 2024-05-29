package model;

import util.Serializacao;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioCRUD {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void atualizar(Funcionario funcionario) {
        int index = funcionarios.indexOf(funcionario);
        if (index >= 0) {
            funcionarios.set(index, funcionario);
        }
    }

    public void remover(int id) {
        if (id >= 0 && id < funcionarios.size()) {
            funcionarios.remove(id);
        }
    }

    public List<Funcionario> listar() {
        return new ArrayList<>(funcionarios);
    }

    public void salvar(String filename) {
        Serializacao.salvarDados(funcionarios, filename);
    }

    public void carregar(String filename) {
        List<String> dados = Serializacao.carregarDados(filename);
        for (String linha : dados) {
            Funcionario funcionario = Funcionario.fromString(linha);
            funcionarios.add(funcionario);
        }
    }
}
