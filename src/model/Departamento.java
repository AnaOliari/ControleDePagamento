package model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    // Atributo que armazena o nome do departamento.
    private String nome;
    // Lista que armazena os funcionários associados a este departamento.
    private List<Funcionario> funcionarios;

    // Construtor que inicializa o nome do departamento e a lista de funcionários.
    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }

    // Método getter para o nome do departamento.
    public String getNome() {
        return nome;
    }

    // Método setter para definir o nome do departamento.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter a lista de funcionários do departamento.
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    // Método para adicionar um funcionário à lista de funcionários do departamento.
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // Método para obter a quantidade de funcionários no departamento.
    public int getQuantidadeFuncionarios() {
        return funcionarios.size();
    }

    // Método toString para representar o departamento como uma string.
    @Override
    public String toString() {
        return "Departamento " + nome;
    }

    // Método estático para criar um objeto Departamento a partir de uma string.
    public static Departamento fromString(String linha) {
        return new Departamento(linha);
    }
}
