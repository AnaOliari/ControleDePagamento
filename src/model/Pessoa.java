// src/model/Pessoa.java
package model;

public class Pessoa {
    // Atributo que armazena o nome da pessoa.
    private String nome;
    // Atributo que armazena o CPF da pessoa.
    private String cpf;
    // Atributo que armazena o endereço da pessoa.
    private String endereco;

    // Construtor que inicializa os atributos da pessoa.
    public Pessoa(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Método getter para o nome da pessoa.
    public String getNome() {
        return nome;
    }

    // Método setter para definir o nome da pessoa.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para o CPF da pessoa.
    public String getCpf() {
        return cpf;
    }

    // Método setter para definir o CPF da pessoa.
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Método getter para o endereço da pessoa.
    public String getEndereco() {
        return endereco;
    }

    // Método setter para definir o endereço da pessoa.
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método toString para representar a pessoa como uma string.
    @Override
    public String toString() {
        return "Funcionario: " + nome + ", CPF: " + cpf + ", endereço: " + endereco;
    }

    // Método estático para criar um objeto Pessoa a partir de uma string.
    public static Pessoa fromString(String linha) {
        // Divide a linha de entrada em partes usando a vírgula como delimitador.
        String[] partes = linha.split(",");
        // Cria e retorna um novo objeto Pessoa usando os dados extraídos.
        return new Pessoa(partes[0], partes[1], partes[2]);
    }
}
