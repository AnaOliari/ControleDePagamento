package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pagamento extends PagamentoBase {
    private int id;
    private Funcionario funcionario;
    private float valor;

    private static int contador = 0;

    public Pagamento(Funcionario funcionario, float valor) {
        this.id = contador++;
        this.funcionario = funcionario;
        this.valor = valor;
    }

    public Pagamento(int id, Funcionario funcionario, float valor) {
        this.id = id;
        this.funcionario = funcionario;
        this.valor = valor;
    }

    @Override
    public float calcularPagamento() {
        return valor;
    }

    public int getId() {
        return id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pagamento.contador = contador;
    }

    @Override
    public String toString() {
        return id + "," + funcionario.getNome() + "," + funcionario.getCpf() + "," + funcionario.getEndereco() + "," + valor;
    }

    public static Pagamento fromString(String linha) {
        String[] partes = linha.split(",");
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String cpf = partes[2];
        String endereco = partes[3];
        float valor = Float.parseFloat(partes[4]);

        Funcionario funcionario = new Funcionario(nome, cpf, endereco, null, 0); 
        return new Pagamento(id, funcionario, valor);
    }

    public void gerarComprovante() {
        String comprovante = "Comprovante de Pagamento\n" +
                "ID do Pagamento: " + id + "\n" +
                "Nome do Funcionário: " + funcionario.getNome() + "\n" +
                "CPF: " + funcionario.getCpf() + "\n" +
                "Endereço: " + funcionario.getEndereco() + "\n" +
                "Valor: " + valor + "\n" +
                "Data do Pagamento: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n";

        System.out.println(comprovante);
    }
}
