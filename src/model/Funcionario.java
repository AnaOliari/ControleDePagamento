package model;

public class Funcionario extends Pessoa {
    private String cargo;
    private float salario;

    public Funcionario(String nome, String cpf, String endereco, String cargo, float salario) {
        super(nome, cpf, endereco);
        this.cargo = cargo;
        this.salario = salario;
    }

    public float calcularPagamento() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + "," + cargo + "," + salario;
    }

    public static Funcionario fromString(String linha) {
        String[] partes = linha.split(",");
        Pessoa pessoa = Pessoa.fromString(String.join(",", partes[0], partes[1], partes[2]));
        return new Funcionario(pessoa.getNome(), pessoa.getCpf(), pessoa.getEndereco(), partes[3], Float.parseFloat(partes[4]));
    }
}
