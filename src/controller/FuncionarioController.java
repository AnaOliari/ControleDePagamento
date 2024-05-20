// src/controller/FuncionarioController.java
package controller;

import model.Funcionario;
import model.Departamento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioController implements CRUD<Funcionario> {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private DepartamentoController departamentoController;

    public FuncionarioController(DepartamentoController departamentoController) {
        this.departamentoController = departamentoController;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        Departamento departamento = departamentoController.encontrarPorId(funcionario.getDepartamentoId());
        if (departamento != null) {
            funcionarios.add(funcionario);
        } else {
            System.out.println("Departamento inválido!");
        }
    }

    @Override
    public void alterar(Funcionario funcionario) {
        Funcionario existente = funcionarios.stream()
                .filter(f -> f.getId() == funcionario.getId())
                .findFirst()
                .orElse(null);
        if (existente != null) {
            existente.setNome(funcionario.getNome());
            existente.setDataNascimento(funcionario.getDataNascimento());
            existente.setCargo(funcionario.getCargo());
            existente.setSalario(funcionario.getSalario());
            existente.setDepartamentoId(funcionario.getDepartamentoId());
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    @Override
    public void deletar(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarios;
    }

    public List<Funcionario> listarFuncionariosPorDepartamento(int departamentoId) {
        return funcionarios.stream()
                .filter(func -> func.getDepartamentoId() == departamentoId)
                .collect(Collectors.toList());
    }

    public List<Funcionario> listar(String cargo) {
        return funcionarios.stream()
                .filter(func -> func.getCargo().equals(cargo))
                .collect(Collectors.toList());
    }
}
