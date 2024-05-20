// src/model/Funcionario.java
package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private int departamentoId;

    public Funcionario(int id, String nome, LocalDate dataNascimento, String cargo, double salario, int departamentoId) {
        super(id, nome, dataNascimento);
        this.cargo = cargo;
        this.salario = salario;
        this.departamentoId = departamentoId;
    }

    // Getters e Setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", departamentoId=" + departamentoId +
                '}';
    }
}
