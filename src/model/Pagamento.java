package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pagamento extends PagamentoBase {
    // Atributo que armazena o ID do pagamento.
    private int id;
    // Atributo que armazena o funcionário associado ao pagamento.
    private Funcionario funcionario;
    // Atributo que armazena o valor do pagamento.
    private float valor;

    // Contador estático para gerar IDs únicos para os pagamentos.
    private static int contador = 0;

    // Construtor que inicializa os atributos do pagamento e gera um ID único.
    public Pagamento(Funcionario funcionario, float valor) {
        this.id = contador++;
        this.funcionario = funcionario;
        this.valor = valor;
    }

    // Construtor sobrecarregado que permite especificar um ID.
    public Pagamento(int id, Funcionario funcionario, float valor) {
        this.id = id;
        this.funcionario = funcionario;
        this.valor = valor;
    }

    // Método sobrescrito da classe abstrata PagamentoBase para calcular o pagamento.
    @Override
    public float calcularPagamento() {
        return valor;
    }

    // Método getter para o ID do pagamento.
    public int getId() {
        return id;
    }

    // Método getter para o funcionário associado ao pagamento.
    public Funcionario getFuncionario() {
        return funcionario;
    }

    // Método setter para definir o funcionário associado ao pagamento.
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    // Método getter para o valor do pagamento.
    public float getValor() {
        return valor;
    }

    // Método setter para definir o valor do pagamento.
    public void setValor(float valor) {
        this.valor = valor;
    }

    // Método getter estático para obter o valor atual do contador.
    public static int getContador() {
        return contador;
    }

    // Método setter estático para definir o valor do contador.
    public static void setContador(int contador) {
        Pagamento.contador = contador;
    }

    // Método toString para representar o pagamento como uma string.
    @Override
    public String toString() {
        return "ID: " + id + ", Funcionario: " + funcionario.getNome() + ", CPF: " + funcionario.getCpf() + ", Endereço: " + funcionario.getEndereco() + ", Pagamento: " + valor + ", Data e hora: "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Método estático para criar um objeto Pagamento a partir de uma string.
    public static Pagamento fromString(String linha) {
        String[] partes = linha.split(",\\s*");
        int id = Integer.parseInt(partes[0].split(": ")[1].trim());
        String nome = partes[1].split(": ")[1].trim();
        String cpf = partes[2].split(": ")[1].trim();
        String endereco = partes[3].split(": ")[1].trim();
        float valor = Float.parseFloat(partes[4].split(": ")[1].trim());

        Funcionario funcionario = new Funcionario(nome, cpf, endereco, null, 0);
        return new Pagamento(id, funcionario, valor);
    }

    // Método para gerar e imprimir um comprovante de pagamento no console.
    public void gerarComprovante() {
        // Cria uma string com as informações do comprovante.
        String comprovante = "Comprovante de Pagamento\n" +
                "ID do Pagamento: " + id + "\n" +
                "Nome do Funcionário: " + funcionario.getNome() + "\n" +
                "CPF: " + funcionario.getCpf() + "\n" +
                "Endereço: " + funcionario.getEndereco() + "\n" +
                "Valor: " + valor + "\n" +
                "Data do Pagamento: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n";

        // Imprime o comprovante no console.
        System.out.println(comprovante);
    }
}

