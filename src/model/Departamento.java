// src/model/Departamento.java
package model;

public class Departamento extends Entidade {
    private String nome;

    public Departamento(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + getId() +
                ", nome='" + nome + '\'' +
                '}';
    }
}
