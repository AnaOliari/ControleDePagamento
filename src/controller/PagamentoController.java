package controller;

import model.Funcionario;
import model.FuncionarioCRUD;
import model.Pagamento;
import model.PagamentoCRUD;
import view.PagamentoView;

public class PagamentoController {
    private FuncionarioCRUD funcionarioCRUD;
    private PagamentoCRUD pagamentoCRUD;
    private PagamentoView pagamentoView;

    public PagamentoController(FuncionarioCRUD funcionarioCRUD, PagamentoCRUD pagamentoCRUD, PagamentoView pagamentoView) {
        this.funcionarioCRUD = funcionarioCRUD;
        this.pagamentoCRUD = pagamentoCRUD;
        this.pagamentoView = pagamentoView;
    }

    public void iniciar() {
        while (true) {
            pagamentoView.mostrarMenu();
            String opcao = pagamentoView.receberEntrada();
            switch (opcao) {
                case "1":
                    adicionarPagamento();
                    break;
                case "2":
                    atualizarPagamento();
                    break;
                case "3":
                    removerPagamento();
                    break;
                case "4":
                    listarPagamentos();
                    break;
                case "0":
                    return;
                default:
                    pagamentoView.exibirMensagem("Opção inválida!");
            }
        }
    }

    private void adicionarPagamento() {
        pagamentoView.exibirMensagem("Adicionar Pagamento");
        pagamentoView.exibirMensagem("CPF do funcionário: ");
        String cpf = pagamentoView.receberEntrada();
        Funcionario funcionario = buscarFuncionarioPorCPF(cpf);
        if (funcionario == null) {
            pagamentoView.exibirMensagem("Funcionário não encontrado!");
            return;
        }

        pagamentoView.exibirMensagem("Nome do Funcionário: " + funcionario.getNome());
        pagamentoView.exibirMensagem("Salário do Funcionário: " + funcionario.getSalario());

        pagamentoView.exibirMensagem("Valor do pagamento: ");
        float valor = Float.parseFloat(pagamentoView.receberEntrada());
        Pagamento pagamento = new Pagamento(funcionario, valor);
        pagamentoCRUD.adicionar(pagamento);
        pagamentoCRUD.salvar("pagamentos.txt");
        pagamentoView.exibirMensagem("Pagamento adicionado com sucesso! ID do pagamento: " );
        pagamento.gerarComprovante();
    }

    private void atualizarPagamento() {
        pagamentoView.exibirMensagem("Atualizar Pagamento");
        pagamentoView.exibirMensagem("ID do pagamento a ser atualizado: ");
        int id = Integer.parseInt(pagamentoView.receberEntrada());
        Pagamento pagamento = pagamentoCRUD.buscarPorId(id);
        if (pagamento == null) {
            pagamentoView.exibirMensagem("Pagamento não encontrado!");
            return;
        }

        pagamentoView.exibirMensagem("Novo valor do pagamento: ");
        float novoValor = Float.parseFloat(pagamentoView.receberEntrada());
        pagamento.setValor(novoValor);
        pagamentoCRUD.atualizar(pagamento);
        pagamentoCRUD.salvar("pagamentos.txt");
        pagamentoView.exibirMensagem("Pagamento atualizado com sucesso!");
    }

    private void removerPagamento() {
        pagamentoView.exibirMensagem("Remover Pagamento");
        pagamentoView.exibirMensagem("ID do pagamento a ser removido: ");
        int id = Integer.parseInt(pagamentoView.receberEntrada());
        Pagamento pagamento = pagamentoCRUD.buscarPorId(id);
        if (pagamento == null) {
            pagamentoView.exibirMensagem("Pagamento não encontrado!");
            return;
        }

        pagamentoCRUD.remover(id);
        pagamentoCRUD.salvar("pagamentos.txt");
        pagamentoView.exibirMensagem("Pagamento removido com sucesso!");
    }

    private void listarPagamentos() {
        pagamentoView.exibirMensagem("Listar Pagamentos");
        for (Pagamento pagamento : pagamentoCRUD.listar()) {
            pagamentoView.exibirMensagem(pagamento.toString());
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
