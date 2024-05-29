package controller;

import model.Departamento;
import model.DepartamentoCRUD;
import view.DepartamentoView;

public class DepartamentoController {
    private DepartamentoCRUD departamentoCRUD;
    private DepartamentoView departamentoView;

    public DepartamentoController(DepartamentoCRUD departamentoCRUD, DepartamentoView departamentoView) {
        this.departamentoCRUD = departamentoCRUD;
        this.departamentoView = departamentoView;
    }

    public void iniciar() {
        while (true) {
            departamentoView.mostrarMenu();
            String opcao = departamentoView.receberEntrada();
            switch (opcao) {
                case "1":
                    adicionarDepartamento();
                    break;
                case "2":
                    atualizarDepartamento();
                    break;
                case "3":
                    removerDepartamento();
                    break;
                case "4":
                    listarDepartamentos();
                    break;
                case "0":
                    return;
                default:
                    departamentoView.exibirMensagem("Opção inválida!");
            }
        }
    }

    private void adicionarDepartamento() {
        departamentoView.exibirMensagem("Adicionar Departamento");
        departamentoView.exibirMensagem("Nome do departamento: ");
        String nome = departamentoView.receberEntrada();

        Departamento departamento = new Departamento(nome);
        departamentoCRUD.adicionar(departamento);
        departamentoView.exibirMensagem("Departamento adicionado com sucesso!");
    }

    private void atualizarDepartamento() {
        departamentoView.exibirMensagem("Atualizar Departamento");
        departamentoView.exibirMensagem("Nome do departamento a ser atualizado: ");
        String nome = departamentoView.receberEntrada();
        Departamento departamento = buscarDepartamentoPorNome(nome);
        if (departamento == null) {
            departamentoView.exibirMensagem("Departamento não encontrado!");
            return;
        }

        departamentoView.exibirMensagem("Novo nome: ");
        String novoNome = departamentoView.receberEntrada();
        departamento.setNome(novoNome);
        departamentoCRUD.atualizar(departamento);
        departamentoView.exibirMensagem("Departamento atualizado com sucesso!");
    }

    private void removerDepartamento() {
        departamentoView.exibirMensagem("Remover Departamento");
        departamentoView.exibirMensagem("Nome do departamento a ser removido: ");
        String nome = departamentoView.receberEntrada();
        Departamento departamento = buscarDepartamentoPorNome(nome);
        if (departamento == null) {
            departamentoView.exibirMensagem("Departamento não encontrado!");
            return;
        }
        departamentoCRUD.remover(departamentoCRUD.listar().indexOf(departamento));
        departamentoView.exibirMensagem("Departamento removido com sucesso!");
    }

    private void listarDepartamentos() {
        departamentoView.exibirMensagem("Listar Departamentos");
        for (Departamento departamento : departamentoCRUD.listar()) {
            departamentoView.exibirMensagem(departamento.toString());
        }
    }

    private Departamento buscarDepartamentoPorNome(String nome) {
        for (Departamento departamento : departamentoCRUD.listar()) {
            if (departamento.getNome().equals(nome)) {
                return departamento;
            }
        }
        return null;
    }
}
