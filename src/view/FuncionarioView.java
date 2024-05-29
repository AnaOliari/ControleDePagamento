package view;

import java.util.Scanner;

public class FuncionarioView {
    private Scanner scanner;

    public FuncionarioView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Atualizar Funcionário");
        System.out.println("3. Remover Funcionário");
        System.out.println("4. Listar Funcionários");
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
