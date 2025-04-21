public class PessoaFisica extends Pessoa {

    private String cpf;
    private char sexo;
    private int estadoCivil;

    public PessoaFisica(String nome, String endereco, String telefone, String cpf, char sexo, int estadoCivil) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "\nCPF: " + cpf + "\nSexo: " + sexo + "\nEstado civil: " + estadoCivil;
    }
}


