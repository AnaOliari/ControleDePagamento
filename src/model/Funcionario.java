package model;

public class Funcionario extends Pessoa {
    // Atributo que armazena o cargo do funcionário.
    private String cargo;
    // Atributo que armazena o salário do funcionário.
    private float salario;
    // Atributo que armazena o departamento do funcionário.
    private Departamento departamento;

    // Construtor que inicializa os atributos do funcionário e chama o construtor da superclasse.
    public Funcionario(String nome, String cpf, String endereco, String cargo, float salario) {
        super(nome, cpf, endereco);
        this.cargo = cargo;
        this.salario = salario;
    }

    // Método para calcular o pagamento do funcionário. Retorna o salário.
    public float calcularPagamento() {
        return salario;
    }

    // Método getter para o cargo do funcionário.
    public String getCargo() {
        return cargo;
    }

    // Método setter para definir o cargo do funcionário.
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método getter para o salário do funcionário.
    public float getSalario() {
        return salario;
    }

    // Método setter para definir o salário do funcionário.
    public void setSalario(float salario) {
        this.salario = salario;
    }

    // Método getter para obter o departamento do funcionário.
    public Departamento getDepartamento() {
        return departamento;
    }

    // Método setter para definir o departamento do funcionário.
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    // Método toString para representar o funcionário como uma string.
    @Override
    public String toString() {
        return super.toString() + ", cargo: " + cargo + ", salario: " + salario + ", departamento: " + (departamento != null ? departamento.getNome() : "Nenhum");
    }

    // Método estático para criar um objeto Funcionario a partir de uma string.
    public static Funcionario fromString(String linha) {
        // Divide a linha de entrada em partes usando a vírgula como delimitador.
        String[] partes = linha.split(",");
        // Cria um objeto Pessoa a partir das três primeiras partes.
        Pessoa pessoa = Pessoa.fromString(String.join(",", partes[0], partes[1], partes[2]));
        // Cria e retorna um novo objeto Funcionario usando os dados da pessoa e as partes restantes da linha.
        return new Funcionario(pessoa.getNome(), pessoa.getCpf(), pessoa.getEndereco(), partes[3], Float.parseFloat(partes[4]));
    }
}
