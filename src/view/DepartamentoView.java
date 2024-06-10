package view;

import java.util.Scanner;

public class DepartamentoView {
    private Scanner scanner;

    public DepartamentoView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println(" ");
        System.out.println("1. Adicionar Departamento");
        System.out.println("2. Atualizar Departamento");
        System.out.println("3. Remover Departamento");
        System.out.println("4. Listar Departamentos");
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
