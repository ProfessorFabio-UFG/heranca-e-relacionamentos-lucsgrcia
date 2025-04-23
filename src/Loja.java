import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {

    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Fornecedor> fornecedores = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n(1)Empregar funcionario" +
                    "\n(2)Cadastrar cliente" +
                    "\n(3)Cadastrar fornecedor" +
                    "\n(4)Demitir funcionario" +
                    "\n(5)Listar funcionarios" +
                    "\n(6)Listar clientes" +
                    "\n(7)Listar fornecedores" +
                    "\n(8)Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            String nome = "", endereco = "", telefone = "", cpf = "", cnpj = "", rs = "", interesses = "", profissao = "", produtos = "";
            char sexo = 'a';
            int ec = 0;
            double renda = 0;


            if (opcao > 0 && opcao < 4) {
                System.out.print("Nome: ");
                nome = sc.nextLine();
                System.out.print("Endereco: ");
                endereco = sc.nextLine();
                System.out.print("Telefone: ");
                telefone = sc.nextLine();

                if (opcao < 3) {
                    System.out.print("CPF: ");
                    cpf = sc.nextLine();
                    System.out.print("Sexo: ");
                    sexo = sc.next().charAt(0);
                    System.out.print("Estado civil: ");
                    ec = sc.nextInt();
                    sc.nextLine();
                } else {
                    System.out.print("CNPJ: ");
                    cnpj = sc.nextLine();
                    System.out.print("Razao Social: ");
                    rs = sc.nextLine();
                }
            }

            switch (opcao) {
                case 1:
                    System.out.print("Matricula: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Salario: ");
                    double sal = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();

                    empregarFuncionario(nome, endereco, telefone, cpf, sexo, ec, matricula, sal, cargo);
                    break;
                case 2:
                    System.out.print("Renda: ");
                    renda = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Interesses: ");
                    interesses = sc.nextLine();
                    System.out.print("Profissao: ");
                    profissao = sc.nextLine();

                    cadastrarCliente(nome, endereco, telefone, cpf, sexo, ec, renda, interesses, profissao);
                    break;
                case 3:
                    System.out.print("Produtos: ");
                    produtos = sc.nextLine();

                    cadastrarFornecedor(nome, endereco, telefone, cnpj, rs, produtos);
                    break;
                case 4:
                    if (!funcionarios.isEmpty()) {
                        System.out.println("Demitir funcionario:");
                        for (Funcionario f : funcionarios) {
                            System.out.println("(" + (funcionarios.indexOf(f) + 1) + ") " + f.getNome());
                        }
                        int indice = sc.nextInt() - 1;
                        demitirFuncionario(funcionarios.get(indice));
                    }
                    break;
                case 5:
                    System.out.println("Lista de funcionarios:");
                    listarFuncionarios();
                    break;
                case 6:
                    System.out.println("Lista de clientes:");
                    listarClientes();
                    break;
                case 7:
                    System.out.println("Lista de fornecedores:");
                    listarFornecedores();
                    break;
                case 8:
                    continuar = false;
                    break;
            }
        }
    }

    public static void empregarFuncionario(String nome, String endereco, String telefone, String cpf, char sexo, int estadoCivil, int matricula, double salario, String cargo) {
        Funcionario f = new Funcionario(nome, endereco, telefone, cpf, sexo, estadoCivil, matricula, salario, cargo);
        System.out.println(f.getNome() + " empregado(a)!");
        funcionarios.add(f);
    }

    public static void demitirFuncionario(Funcionario f) {
        System.out.println(f.getNome() + " demitido(a)!");
        funcionarios.remove(f);
    }

    public static void cadastrarCliente(String nome, String endereco, String telefone, String cpf, char sexo, int estadoCivil, double renda, String interesses, String profissao) {
        Cliente c = new Cliente(nome, endereco, telefone, cpf, sexo, estadoCivil, renda, interesses, profissao);
        System.out.println(c.getNome() + " cadastrado(a)!");
        clientes.add(c);
    }

    public static void cadastrarFornecedor(String nome, String endereco, String telefone, String cnpj, String razaoSocial, String produtos) {
        Fornecedor fornecedor = new Fornecedor(nome, endereco, telefone, cnpj, razaoSocial, produtos);
        System.out.println(fornecedor.getNome() + " cadastrado(a)!");
        fornecedores.add(fornecedor);
    }

    public static void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f);
            System.out.println();
        }
    }

    public static void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
            System.out.println();
        }
    }

    public static void listarFornecedores() {
        for (Fornecedor f : fornecedores) {
            System.out.println(f);
            System.out.println();
        }
    }
}
