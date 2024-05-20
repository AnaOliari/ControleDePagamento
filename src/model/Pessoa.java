// src/model/Pessoa.java
package model;

import java.time.LocalDate;

public abstract class Pessoa extends Entidade {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(int id, String nome, LocalDate dataNascimento) {
        super(id);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + getId() +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
