import java.time.LocalDate;

import controller.FuncionarioController;
import model.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        FuncionarioController funcionarioController = new FuncionarioController();

        // Exemplo de uso do método listarFuncionariosPorDepartamento
        funcionarioController.cadastrar(new Funcionario(1, "João", LocalDate.of(1985, 5, 20), "Desenvolvedor", 5000.0, 1));
        funcionarioController.cadastrar(new Funcionario(2, "Maria", LocalDate.of(1990, 7, 15), "Designer", 4000.0, 2));
        funcionarioController.cadastrar(new Funcionario(3, "Pedro", LocalDate.of(1982, 11, 30), "Gerente", 6000.0, 1));

        System.out.println("Funcionários do departamento 1:");
        funcionarioController.listarFuncionariosPorDepartamento(1).forEach(System.out::println);
    }
}
