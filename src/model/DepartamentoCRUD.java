package model;

import util.Serializacao;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoCRUD {
    private List<Departamento> departamentos = new ArrayList<>();

    public void adicionar(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void atualizar(Departamento departamento) {
        int index = departamentos.indexOf(departamento);
        if (index >= 0) {
            departamentos.set(index, departamento);
        }
    }

    public void remover(int id) {
        if (id >= 0 && id < departamentos.size()) {
            departamentos.remove(id);
        }
    }

    public List<Departamento> listar() {
        return new ArrayList<>(departamentos);
    }

    public void salvar(String filename) {
        Serializacao.salvarDados(departamentos, filename);
    }

    public void carregar(String filename) {
        List<String> dados = Serializacao.carregarDados(filename);
        for (String linha : dados) {
            Departamento departamento = Departamento.fromString(linha);
            departamentos.add(departamento);
        }
    }
}
