package view;

import java.util.Scanner;

public class PagamentoView {
    // Atributo que armazena o scanner para leitura de entradas do usuário.
    private Scanner scanner;

    // Construtor que inicializa o scanner.
    public PagamentoView() {
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu de opções para o usuário.
    public void mostrarMenu() {
        System.out.println(" ");
        System.out.println("1. Adicionar Pagamento");
        System.out.println("2. Atualizar Pagamento");
        System.out.println("3. Remover Pagamento");
        System.out.println("4. Listar Pagamentos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Método para exibir uma mensagem para o usuário.
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Método para receber uma entrada do usuário.
    public String receberEntrada() {
        return scanner.nextLine();
    }
}
