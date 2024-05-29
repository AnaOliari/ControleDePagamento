package controller;

import model.Funcionario;
import model.FuncionarioCRUD;
import view.FuncionarioView;

public class FuncionarioController {
    private FuncionarioCRUD funcionarioCRUD;
    private FuncionarioView funcionarioView;

    public FuncionarioController(FuncionarioCRUD funcionarioCRUD, FuncionarioView funcionarioView) {
        this.funcionarioCRUD = funcionarioCRUD;
        this.funcionarioView = funcionarioView;
    }

    public void iniciar() {
        while (true) {
            funcionarioView.mostrarMenu();
            String opcao = funcionarioView.receberEntrada();
            switch (opcao) {
                case "1":
                    adicionarFuncionario();
                    break;
                case "2":
                    atualizarFuncionario();
                    break;
                case "3":
                    removerFuncionario();
                    break;
                case "4":
                    listarFuncionarios();
                    break;
                case "0":
                    return;
                default:
                    funcionarioView.exibirMensagem("Opção inválida!");
            }
        }
    }

    private void adicionarFuncionario() {
        funcionarioView.exibirMensagem("Adicionar Funcionário");
        funcionarioView.exibirMensagem("Nome: ");
        String nome = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("CPF: ");
        String cpf = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Endereço: ");
        String endereco = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Cargo: ");
        String cargo = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Salário: ");
        float salario = Float.parseFloat(funcionarioView.receberEntrada());

        Funcionario funcionario = new Funcionario(nome, cpf, endereco, cargo, salario);
        funcionarioCRUD.adicionar(funcionario);
        funcionarioView.exibirMensagem("Funcionário adicionado com sucesso!");
    }

    private void atualizarFuncionario() {
        funcionarioView.exibirMensagem("Atualizar Funcionário");
        funcionarioView.exibirMensagem("CPF do funcionário a ser atualizado: ");
        String cpf = funcionarioView.receberEntrada();
        Funcionario funcionario = buscarFuncionarioPorCPF(cpf);
        if (funcionario == null) {
            funcionarioView.exibirMensagem("Funcionário não encontrado!");
            return;
        }

        funcionarioView.exibirMensagem("Novo nome: ");
        String nome = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Novo endereço: ");
        String endereco = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Novo cargo: ");
        String cargo = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Novo salário: ");
        float salario = Float.parseFloat(funcionarioView.receberEntrada());

        funcionario.setNome(nome);
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        funcionarioCRUD.atualizar(funcionario);
        funcionarioView.exibirMensagem("Funcionário atualizado com sucesso!");
    }

    private void removerFuncionario() {
        funcionarioView.exibirMensagem("Remover Funcionário");
        funcionarioView.exibirMensagem("CPF do funcionário a ser removido: ");
        String cpf = funcionarioView.receberEntrada();
        Funcionario funcionario = buscarFuncionarioPorCPF(cpf);
        if (funcionario == null) {
            funcionarioView.exibirMensagem("Funcionário não encontrado!");
            return;
        }
        funcionarioCRUD.remover(funcionarioCRUD.listar().indexOf(funcionario));
        funcionarioView.exibirMensagem("Funcionário removido com sucesso!");
    }

    private void listarFuncionarios() {
        funcionarioView.exibirMensagem("Listar Funcionários");
        for (Funcionario funcionario : funcionarioCRUD.listar()) {
            funcionarioView.exibirMensagem(funcionario.toString());
        }
    }

    private Funcionario buscarFuncionarioPorCPF(String cpf) {
        for (Funcionario funcionario : funcionarioCRUD.listar()) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }
}
