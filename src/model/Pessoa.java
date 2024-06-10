// src/model/Pessoa.java
package model;

public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;

    public Pessoa(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "Funcionario: " + nome + ", CPF: " + cpf + ", endereço: " + endereco;
    }

    public static Pessoa fromString(String linha) {
        String[] partes = linha.split(",");
        return new Pessoa(partes[0], partes[1], partes[2]);
    }
}
