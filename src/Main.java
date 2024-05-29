import model.FuncionarioCRUD;
import model.DepartamentoCRUD;
import model.PagamentoCRUD;
import view.FuncionarioView;
import view.DepartamentoView;
import view.PagamentoView;
import controller.FuncionarioController;
import controller.DepartamentoController;
import controller.PagamentoController;

public class Main {
    public static void main(String[] args) {
        // Instanciar os CRUDs
        FuncionarioCRUD funcionarioCRUD = new FuncionarioCRUD();
        DepartamentoCRUD departamentoCRUD = new DepartamentoCRUD();
        PagamentoCRUD pagamentoCRUD = new PagamentoCRUD();

        // Carregar dados dos arquivos
        funcionarioCRUD.carregar("funcionarios.txt");
        departamentoCRUD.carregar("departamentos.txt");
        pagamentoCRUD.carregar("pagamentos.txt");

        // Instanciar as Views
        FuncionarioView funcionarioView = new FuncionarioView();
        DepartamentoView departamentoView = new DepartamentoView();
        PagamentoView pagamentoView = new PagamentoView();

        // Instanciar os Controllers
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioCRUD, funcionarioView);
        DepartamentoController departamentoController = new DepartamentoController(departamentoCRUD, departamentoView);
        PagamentoController pagamentoController = new PagamentoController(funcionarioCRUD, pagamentoCRUD, pagamentoView);

        // Iniciar a aplicação
        while (true) {
            System.out.println("Sistema de Controle de Pagamentos");
            System.out.println("1. Gerenciar Funcionários");
            System.out.println("2. Gerenciar Departamentos");
            System.out.println("3. Gerenciar Pagamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            String opcao = funcionarioView.receberEntrada();

            switch (opcao) {
                case "1":
                    funcionarioController.iniciar();
                    break;
                case "2":
                    departamentoController.iniciar();
                    break;
                case "3":
                    pagamentoController.iniciar();
                    break;
                case "0":
                    System.out.println("Encerrando o sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
