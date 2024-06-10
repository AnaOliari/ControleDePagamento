package view;

import java.util.Scanner;

public class PagamentoView {
    private Scanner scanner;

    public PagamentoView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println(" ");
        System.out.println("1. Adicionar Pagamento");
        System.out.println("2. Atualizar Pagamento");
        System.out.println("3. Remover Pagamento");
        System.out.println("4. Listar Pagamentos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String receberEntrada() {
        return scanner.nextLine();
    }
}
