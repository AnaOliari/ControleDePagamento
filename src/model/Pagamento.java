package model;

public class Pagamento extends PagamentoBase {
    private Funcionario funcionario;
    private float valor;

    public Pagamento(Funcionario funcionario, float valor) {
        this.funcionario = funcionario;
        this.valor = valor;
    }

    @Override
    public float calcularPagamento() {
        return valor;
    }

    @Override
    public String toString() {
        return funcionario.getNome() + "," + funcionario.getCpf() + "," + funcionario.getEndereco() + "," + valor;
    }

    public static Pagamento fromString(String linha) {
        String[] partes = linha.split(",");
        Funcionario funcionario = new Funcionario(partes[0], partes[1], partes[2], null, 0); 
        return new Pagamento(funcionario, Float.parseFloat(partes[3]));
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
}
