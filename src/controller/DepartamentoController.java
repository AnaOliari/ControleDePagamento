// src/controller/DepartamentoController.java
package controller;

import model.Departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoController implements CRUD<Departamento> {
  private List<Departamento> departamentos = new ArrayList<>();


    @Override
    public void cadastrar(Departamento departamento) {
        departamentos.add(departamento);
    }

    @Override
    public void alterar(Departamento departamento) {
        Departamento existente = departamentos.stream()
                .filter(d -> d.getId() == departamento.getId())
                .findFirst()
                .orElse(null);
        if (existente != null) {
            existente.setNome(departamento.getNome());
        } else {
            System.out.println("Departamento não encontrado!");
        }
    }

    @Override
    public void deletar(int id) {
        departamentos.removeIf(departamento -> departamento.getId() == id);
    }

    @Override
    public List<Departamento> listar() {
        return departamentos;
    }

    public Departamento encontrarPorId(int id) {
        return departamentos.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
