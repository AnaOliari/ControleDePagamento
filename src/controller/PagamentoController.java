package controller;

import crud.FuncionarioCRUD;
import crud.PagamentoCRUD;
import model.Funcionario;
import model.Pagamento;
import view.PagamentoView;

public class PagamentoController {
    private FuncionarioCRUD funcionarioCRUD;
    private PagamentoCRUD pagamentoCRUD;
    private PagamentoView pagamentoView;

    // Construtor da classe, inicializa os objetos de CRUD e View.
    public PagamentoController(FuncionarioCRUD funcionarioCRUD, PagamentoCRUD pagamentoCRUD, PagamentoView pagamentoView) {
        this.funcionarioCRUD = funcionarioCRUD;
        this.pagamentoCRUD = pagamentoCRUD;
        this.pagamentoView = pagamentoView;
    }

    // Método principal para iniciar o loop de interação com o usuário.
    public void iniciar() {
        while (true) {
            // Exibe o menu de opções para o usuário.
            pagamentoView.mostrarMenu();
            // Recebe a opção escolhida pelo usuário.
            String opcao = pagamentoView.receberEntrada();
            // Realiza uma ação com base na opção escolhida.
            switch (opcao) {
                case "1":
                    // Adiciona um novo pagamento.
                    adicionarPagamento();
                    break;
                case "2":
                    // Atualiza um pagamento existente.
                    atualizarPagamento();
                    break;
                case "3":
                    // Remove um pagamento existente.
                    removerPagamento();
                    break;
                case "4":
                    // Lista todos os pagamentos.
                    listarPagamentos();
                    break;
                case "0":
                    // Encerra o loop e sai do método.
                    return;
                default:
                    // Exibe mensagem de erro para opção inválida.
                    pagamentoView.exibirMensagem("Opção inválida!");
            }
        }
    }

    // Método para adicionar um novo pagamento.
    private void adicionarPagamento() {
        // Exibe mensagem solicitando o CPF do funcionário.
        pagamentoView.exibirMensagem("Adicionar Pagamento");
        pagamentoView.exibirMensagem("CPF do funcionário: ");
        // Recebe o CPF do funcionário.
        String cpf = pagamentoView.receberEntrada();
        // Busca o funcionário pelo CPF.
        Funcionario funcionario = buscarFuncionarioPorCPF(cpf);
        if (funcionario == null) {
            // Exibe mensagem de erro se o funcionário não for encontrado.
            pagamentoView.exibirMensagem("Funcionário não encontrado!");
            return;
        }

        // Exibe informações do funcionário.
        pagamentoView.exibirMensagem("Nome do Funcionário: " + funcionario.getNome());
        pagamentoView.exibirMensagem("Salário do Funcionário: " + funcionario.getSalario());

        // Exibe mensagem solicitando o valor do pagamento.
        pagamentoView.exibirMensagem("Valor do pagamento: ");
        // Recebe o valor do pagamento.
        float valor = Float.parseFloat(pagamentoView.receberEntrada());
        // Cria um novo objeto Pagamento com os dados fornecidos.
        Pagamento pagamento = new Pagamento(funcionario, valor);
        // Adiciona o pagamento ao CRUD.
        pagamentoCRUD.adicionar(pagamento);
        // Salva os pagamentos no arquivo.
        pagamentoCRUD.salvar("arquivoTXT/pagamentos.txt");
        // Exibe mensagem de sucesso com o ID do pagamento.
        pagamentoView.exibirMensagem("Pagamento adicionado com sucesso! ID do pagamento: " + pagamento.getId());
        // Gera o comprovante de pagamento.
        pagamento.gerarComprovante();
    }

    // Método para atualizar um pagamento existente.
    private void atualizarPagamento() {
        // Exibe mensagem solicitando o ID do pagamento a ser atualizado.
        pagamentoView.exibirMensagem("Atualizar Pagamento");
        pagamentoView.exibirMensagem("ID do pagamento a ser atualizado: ");
        // Recebe o ID do pagamento.
        int id = Integer.parseInt(pagamentoView.receberEntrada());
        // Busca o pagamento pelo ID.
        Pagamento pagamento = pagamentoCRUD.buscarPorId(id);
        if (pagamento == null) {
            // Exibe mensagem de erro se o pagamento não for encontrado.
            pagamentoView.exibirMensagem("Pagamento não encontrado!");
            return;
        }

        // Exibe mensagem solicitando o novo valor do pagamento.
        pagamentoView.exibirMensagem("Novo valor do pagamento: ");
        // Recebe o novo valor do pagamento.
        float novoValor = Float.parseFloat(pagamentoView.receberEntrada());
        // Atualiza o valor do pagamento.
        pagamento.setValor(novoValor);
        // Atualiza o pagamento no CRUD.
        pagamentoCRUD.atualizar(pagamento);
        // Salva os pagamentos no arquivo.
        pagamentoCRUD.salvar("arquivoTXT/pagamentos.txt");
        // Exibe mensagem de sucesso.
        pagamentoView.exibirMensagem("Pagamento atualizado com sucesso!");
    }

    // Método para remover um pagamento existente.
    private void removerPagamento() {
        // Exibe mensagem solicitando o ID do pagamento a ser removido.
        pagamentoView.exibirMensagem("Remover Pagamento");
        pagamentoView.exibirMensagem("ID do pagamento a ser removido: ");
        // Recebe o ID do pagamento.
        int id = Integer.parseInt(pagamentoView.receberEntrada());
        // Busca o pagamento pelo ID.
        Pagamento pagamento = pagamentoCRUD.buscarPorId(id);
        if (pagamento == null) {
            // Exibe mensagem de erro se o pagamento não for encontrado.
            pagamentoView.exibirMensagem("Pagamento não encontrado!");
            return;
        }

        // Remove o pagamento do CRUD.
        pagamentoCRUD.remover(id);
        // Salva os pagamentos no arquivo.
        pagamentoCRUD.salvar("arquivoTXT/pagamentos.txt");
        // Exibe mensagem de sucesso.
        pagamentoView.exibirMensagem("Pagamento removido com sucesso!");
    }

    // Método para listar todos os pagamentos.
    private void listarPagamentos() {
        // Exibe mensagem de listagem.
        pagamentoView.exibirMensagem("Listar Pagamentos");
        // Itera sobre todos os pagamentos no CRUD.
        for (Pagamento pagamento : pagamentoCRUD.listar()) {
            // Exibe cada pagamento.
            pagamentoView.exibirMensagem(pagamento.toString());
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
