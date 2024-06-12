package controller;

import crud.DepartamentoCRUD;
import model.Departamento;
import view.DepartamentoView;

public class DepartamentoController {
    private DepartamentoCRUD departamentoCRUD;
    private DepartamentoView departamentoView;

    // Construtor da classe, inicializa os objetos de CRUD e View.
    public DepartamentoController(DepartamentoCRUD departamentoCRUD, DepartamentoView departamentoView) {
        this.departamentoCRUD = departamentoCRUD;
        this.departamentoView = departamentoView;
    }

    // Método principal para iniciar o loop de interação com o usuário.
    public void iniciar() {
        while (true) {
            // Exibe o menu de opções para o usuário.
            departamentoView.mostrarMenu();
            // Recebe a opção escolhida pelo usuário.
            String opcao = departamentoView.receberEntrada();
            // Realiza uma ação com base na opção escolhida.
            switch (opcao) {
                case "1":
                    // Adiciona um novo departamento.
                    adicionarDepartamento();
                    break;
                case "2":
                    // Atualiza um departamento existente.
                    atualizarDepartamento();
                    break;
                case "3":
                    // Remove um departamento existente.
                    removerDepartamento();
                    break;
                case "4":
                    // Lista todos os departamentos.
                    listarDepartamentos();
                    break;
                case "0":
                    // Encerra o loop e sai do método.
                    return;
                default:
                    // Exibe mensagem de erro para opção inválida.
                    departamentoView.exibirMensagem("Opção inválida!");
            }
        }
    }

    // Método para adicionar um novo departamento.
    private void adicionarDepartamento() {
        // Exibe mensagem solicitando o nome do novo departamento.
        departamentoView.exibirMensagem("Adicionar Departamento");
        departamentoView.exibirMensagem("Nome do departamento: ");
        // Recebe o nome do novo departamento.
        String nome = departamentoView.receberEntrada();

        // Cria um novo objeto Departamento com o nome fornecido.
        Departamento departamento = new Departamento(nome);
        // Adiciona o novo departamento ao CRUD.
        departamentoCRUD.adicionar(departamento);
        // Exibe mensagem de sucesso.
        departamentoView.exibirMensagem("Departamento adicionado com sucesso!");
    }

    // Método para atualizar um departamento existente.
    private void atualizarDepartamento() {
        // Exibe mensagem solicitando o nome do departamento a ser atualizado.
        departamentoView.exibirMensagem("Atualizar Departamento");
        departamentoView.exibirMensagem("Nome do departamento a ser atualizado: ");
        // Recebe o nome do departamento a ser atualizado.
        String nome = departamentoView.receberEntrada();
        // Busca o departamento pelo nome.
        Departamento departamento = departamentoCRUD.buscarPorNome(nome);
        if (departamento == null) {
            // Exibe mensagem de erro se o departamento não for encontrado.
            departamentoView.exibirMensagem("Departamento não encontrado!");
            return;
        }

        // Exibe mensagem solicitando o novo nome do departamento.
        departamentoView.exibirMensagem("Novo nome: ");
        // Recebe o novo nome do departamento.
        String novoNome = departamentoView.receberEntrada();
        // Define o novo nome no objeto Departamento.
        departamento.setNome(novoNome);
        // Atualiza o departamento no CRUD.
        departamentoCRUD.atualizar(departamento);
        // Exibe mensagem de sucesso.
        departamentoView.exibirMensagem("Departamento atualizado com sucesso!");
    }

    // Método para remover um departamento existente.
    private void removerDepartamento() {
        // Exibe mensagem solicitando o nome do departamento a ser removido.
        departamentoView.exibirMensagem("Remover Departamento");
        departamentoView.exibirMensagem("Nome do departamento a ser removido: ");
        // Recebe o nome do departamento a ser removido.
        String nome = departamentoView.receberEntrada();
        // Busca o departamento pelo nome.
        Departamento departamento = departamentoCRUD.buscarPorNome(nome);
        if (departamento == null) {
            // Exibe mensagem de erro se o departamento não for encontrado.
            departamentoView.exibirMensagem("Departamento não encontrado!");
            return;
        }
        // Remove o departamento do CRUD com base no índice.
        departamentoCRUD.remover(departamentoCRUD.listar().indexOf(departamento));
        // Exibe mensagem de sucesso.
        departamentoView.exibirMensagem("Departamento removido com sucesso!");
    }

    // Método para listar todos os departamentos.
    private void listarDepartamentos() {
        // Exibe mensagem de listagem.
        departamentoView.exibirMensagem("Listar Departamentos");
        // Itera sobre todos os departamentos no CRUD.
        for (Departamento departamento : departamentoCRUD.listar()) {
            // Exibe cada departamento e a quantidade de funcionários.
            departamentoView.exibirMensagem(departamento.toString() + " - Quantidade de Funcionários: " + departamento.getQuantidadeFuncionarios());
        }
    }
}
