// src/controller/FuncionarioController.java
package controller;

import crud.DepartamentoCRUD;
import crud.FuncionarioCRUD;
import model.Departamento;
import model.Funcionario;
import view.FuncionarioView;

public class FuncionarioController {
    private FuncionarioCRUD funcionarioCRUD;
    private FuncionarioView funcionarioView;
    private DepartamentoCRUD departamentoCRUD;

    // Construtor da classe, inicializa os objetos de CRUD e View.
    public FuncionarioController(FuncionarioCRUD funcionarioCRUD, FuncionarioView funcionarioView, DepartamentoCRUD departamentoCRUD) {
        this.funcionarioCRUD = funcionarioCRUD;
        this.funcionarioView = funcionarioView;
        this.departamentoCRUD = departamentoCRUD;
    }

    // Método principal para iniciar o loop de interação com o usuário.
    public void iniciar() {
        while (true) {
            // Exibe o menu de opções para o usuário.
            funcionarioView.mostrarMenu();
            // Recebe a opção escolhida pelo usuário.
            String opcao = funcionarioView.receberEntrada();
            // Realiza uma ação com base na opção escolhida.
            switch (opcao) {
                case "1":
                    // Adiciona um novo funcionário.
                    adicionarFuncionario();
                    break;
                case "2":
                    // Atualiza um funcionário existente.
                    atualizarFuncionario();
                    break;
                case "3":
                    // Remove um funcionário existente.
                    removerFuncionario();
                    break;
                case "4":
                    // Lista todos os funcionários.
                    listarFuncionarios();
                    break;
                case "0":
                    // Encerra o loop e sai do método.
                    return;
                default:
                    // Exibe mensagem de erro para opção inválida.
                    funcionarioView.exibirMensagem("Opção inválida!");
            }
        }
    }

    // Método para adicionar um novo funcionário.
    private void adicionarFuncionario() {
        // Exibe mensagens solicitando os dados do novo funcionário.
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
        funcionarioView.exibirMensagem("Departamento: ");
        String departamentoNome = funcionarioView.receberEntrada();

        // Busca o departamento pelo nome fornecido.
        Departamento departamento = departamentoCRUD.buscarPorNome(departamentoNome);
        if (departamento == null) {
            // Exibe mensagem de erro se o departamento não for encontrado.
            funcionarioView.exibirMensagem("Departamento não encontrado!");
            return;
        }

        // Cria um novo objeto Funcionario com os dados fornecidos.
        Funcionario funcionario = new Funcionario(nome, cpf, endereco, cargo, salario);
        funcionario.setDepartamento(departamento);
        departamento.adicionarFuncionario(funcionario);
        funcionarioCRUD.adicionar(funcionario);
        // Exibe mensagem de sucesso.
        funcionarioView.exibirMensagem("Funcionário adicionado com sucesso!");
    }

    // Método para atualizar um funcionário existente.
    private void atualizarFuncionario() {
        // Exibe mensagem solicitando o CPF do funcionário a ser atualizado.
        funcionarioView.exibirMensagem("Atualizar Funcionário");
        funcionarioView.exibirMensagem("CPF do funcionário a ser atualizado: ");
        String cpf = funcionarioView.receberEntrada();
        // Busca o funcionário pelo CPF.
        Funcionario funcionario = buscarFuncionarioPorCPF(cpf);
        if (funcionario == null) {
            // Exibe mensagem de erro se o funcionário não for encontrado.
            funcionarioView.exibirMensagem("Funcionário não encontrado!");
            return;
        }

        // Exibe mensagens solicitando os novos dados do funcionário.
        funcionarioView.exibirMensagem("Novo nome: ");
        String nome = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Novo endereço: ");
        String endereco = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Novo cargo: ");
        String cargo = funcionarioView.receberEntrada();
        funcionarioView.exibirMensagem("Novo salário: ");
        float salario = Float.parseFloat(funcionarioView.receberEntrada());
        funcionarioView.exibirMensagem("Novo departamento: ");
        String departamentoNome = funcionarioView.receberEntrada();

        // Busca o novo departamento pelo nome fornecido.
        Departamento novoDepartamento = departamentoCRUD.buscarPorNome(departamentoNome);
        if (novoDepartamento == null) {
            // Exibe mensagem de erro se o novo departamento não for encontrado.
            funcionarioView.exibirMensagem("Departamento não encontrado!");
            return;
        }

        // Remove o funcionário do departamento atual, se existir.
        Departamento departamentoAtual = funcionario.getDepartamento();
        if (departamentoAtual != null) {
            departamentoAtual.getFuncionarios().remove(funcionario);
        }

        // Atualiza os dados do funcionário.
        funcionario.setNome(nome);
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        funcionario.setDepartamento(novoDepartamento);
        novoDepartamento.adicionarFuncionario(funcionario);

        funcionarioCRUD.atualizar(funcionario);
        // Exibe mensagem de sucesso.
        funcionarioView.exibirMensagem("Funcionário atualizado com sucesso!");
    }

    // Método para remover um funcionário existente.
    private void removerFuncionario() {
        // Exibe mensagem solicitando o CPF do funcionário a ser removido.
        funcionarioView.exibirMensagem("Remover Funcionário");
        funcionarioView.exibirMensagem("CPF do funcionário a ser removido: ");
        String cpf = funcionarioView.receberEntrada();
        // Busca o funcionário pelo CPF.
        Funcionario funcionario = buscarFuncionarioPorCPF(cpf);
        if (funcionario == null) {
            // Exibe mensagem de erro se o funcionário não for encontrado.
            funcionarioView.exibirMensagem("Funcionário não encontrado!");
            return;
        }

        // Remove o funcionário do departamento atual, se existir.
        Departamento departamento = funcionario.getDepartamento();
        if (departamento != null) {
            departamento.getFuncionarios().remove(funcionario);
        }

        // Remove o funcionário do CRUD.
        funcionarioCRUD.remover(funcionarioCRUD.listar().indexOf(funcionario));
        // Exibe mensagem de sucesso.
        funcionarioView.exibirMensagem("Funcionário removido com sucesso!");
    }

    // Método para listar todos os funcionários.
    private void listarFuncionarios() {
        // Exibe mensagem de listagem.
        funcionarioView.exibirMensagem("Listar Funcionários");
        // Itera sobre todos os funcionários no CRUD.
        for (Funcionario funcionario : funcionarioCRUD.listar()) {
            // Exibe cada funcionário.
            funcionarioView.exibirMensagem(funcionario.toString());
        }
    }

    // Método auxiliar para buscar um funcionário pelo CPF.
    private Funcionario buscarFuncionarioPorCPF(String cpf) {
        for (Funcionario funcionario : funcionarioCRUD.listar()) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }
}
