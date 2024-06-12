//Controle de pagamento 
//Ana Carolina OLiari RGM 35984970
//Matheus João Correa 

import view.FuncionarioView;
import view.DepartamentoView;
import view.PagamentoView;
import controller.FuncionarioController;
import controller.DepartamentoController;
import controller.PagamentoController;
import crud.DepartamentoCRUD;
import crud.FuncionarioCRUD;
import crud.PagamentoCRUD;

public class Main {
    public static void main(String[] args) {
        // Instanciar os CRUDs (criação, leitura, atualização e deleção)
        FuncionarioCRUD funcionarioCRUD = new FuncionarioCRUD();
        DepartamentoCRUD departamentoCRUD = new DepartamentoCRUD();
        PagamentoCRUD pagamentoCRUD = new PagamentoCRUD();

        // Carregar dados dos arquivos
        pagamentoCRUD.carregar("arquivoTXT/pagamentos.txt");

        // Instanciar as Views (interfaces de usuário)
        FuncionarioView funcionarioView = new FuncionarioView();
        DepartamentoView departamentoView = new DepartamentoView();
        PagamentoView pagamentoView = new PagamentoView();

        // Instanciar os Controllers (controladores de lógica de negócio)
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioCRUD, funcionarioView, departamentoCRUD);
        DepartamentoController departamentoController = new DepartamentoController(departamentoCRUD, departamentoView);
        PagamentoController pagamentoController = new PagamentoController(funcionarioCRUD, pagamentoCRUD, pagamentoView);

        // Iniciar a aplicação em um loop contínuo
        while (true) {
            System.out.println(" ");
            System.out.println("--- Sistema de Controle de Pagamentos ---");
            System.out.println("1. Gerenciar Departamentos");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Pagamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            // Receber a entrada do usuário
            String opcao = funcionarioView.receberEntrada();

            // Executar a ação correspondente à opção escolhida pelo usuário
            switch (opcao) {
                case "1":
                    // Iniciar o controlador de departamentos
                    departamentoController.iniciar();
                    break;
                case "2":
                    // Iniciar o controlador de funcionários
                    funcionarioController.iniciar();
                    break;
                case "3":
                    // Iniciar o controlador de pagamentos
                    pagamentoController.iniciar();
                    break;
                case "0":
                    // Salvar dados antes de encerrar o sistema
                    pagamentoCRUD.salvar("arquivoTXT/pagamentos.txt");
                    System.out.println("Encerrando o sistema...");
                    return;
                default:
                    // Opção inválida
                    System.out.println("Opção inválida!");
            }
        }
    }
}
