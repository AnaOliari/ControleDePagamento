package model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Funcionario> funcionarios;

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public int getQuantidadeFuncionarios() {
        return funcionarios.size();
    }

    @Override
    public String toString() {
        return "Departamento " + nome;
    }

    public static Departamento fromString(String linha) {
        return new Departamento(linha);
    }
}
