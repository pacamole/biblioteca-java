package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Biblioteca;
import model.Livro; // Adicionando a importação da classe Livro

public class Menu {

    Biblioteca biblioteca;
    Scanner entrada;

    public Menu(Biblioteca biblioteca, Scanner entrada) {
        this.biblioteca = biblioteca;
        this.entrada = entrada;
    }

    private void limparMenu() {
        System.out.print("\033c");
    }

    private void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("3. Emprestar livro");
        System.out.println("4. Devolver livro");
        System.out.println("5. Relatório de livros");
        System.out.println("6. Sair");
    }

    public void iniciarMenu() {
        int opcao = 0;
        String mensagem = "";

        while (opcao != 6) {
            opcao = 0;
            this.limparMenu();
            this.entrada.reset();

            if (!mensagem.isEmpty()) {
                System.out.println(mensagem);
                mensagem = "";
            }
            this.mostrarMenu();

            System.out.print("Escolha uma opção: ");
            opcao = this.entrada.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        this.entrada.reset();
                        this.cadastrarLivro();
                        break;
                    case 2:
                        this.entrada.reset();
                        this.cadastrarUsuario();
                        break;
                    case 3:
                        this.entrada.reset();
                        this.emprestarLivro();
                        break;
                    case 4:
                        this.entrada.reset();
                        this.devolverLivro();
                        break;
                    case 5:
                        this.entrada.reset();
                        this.relatorioLivros();
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        throw new Exception("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                mensagem = e.toString();
            }
        }
    }

    public void cadastrarLivro() {
        this.limparMenu();
        System.out.println("-- Cadastrar Livro");

        System.out.println("Digite o título do livro:");
        String titulo = this.entrada.nextLine().trim();

        System.out.println("Digite o autor do livro:");
        String autor = this.entrada.nextLine().trim();

        System.out.println("Digite o ano de publicação do livro:");
        int anoPublicacao = this.entrada.nextInt();

        System.out.println("Digite o número de exemplares disponíveis:");
        int numeroExemplares = this.entrada.nextInt();

        System.out.println("Digite a categoria do livro:");
        String categoria = this.entrada.nextLine().trim();

        this.biblioteca.newLivro(titulo, autor, anoPublicacao, numeroExemplares, categoria);

        System.out.println("Livro cadastrado com sucesso!");
        this.entrada.nextLine();
    }

    public void cadastrarUsuario() {
        this.limparMenu();
        System.out.println("-- Cadastrar Usuário");

        String nome;
        while (true) {
            System.out.println("Digite o nome do usuário:");
            nome = this.entrada.nextLine().trim();
            if (!nome.isEmpty())
                break;
            System.out.println("Nome não pode ser vazio. Tente novamente.");
        }

        int telefone;
        while (true) {
            System.out.println("Digite o telefone do usuário (somente números):");
            String telefoneStr = this.entrada.nextLine().trim();
            try {
                telefone = Integer.parseInt(telefoneStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Telefone inválido! Digite apenas números.");
            }
        }

        String endereco;
        while (true) {
            System.out.println("Digite o endereço do usuário:");
            endereco = this.entrada.nextLine().trim();
            if (!endereco.isEmpty())
                break;
            System.out.println("Endereço não pode ser vazio. Tente novamente.");
        }

        String email;
        while (true) {
            System.out.println("Digite o Email do usuário:");
            email = this.entrada.nextLine().trim();
            if (email.contains("@"))
                break;
            System.out.println("Email inválido! Deve conter '@'.");
        }

        this.biblioteca.newUsuario(nome, telefone, endereco, email);
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        this.entrada.nextLine();
    }

    public void emprestarLivro() {
        this.limparMenu();
        System.out.println("-- Emprestar Livro");

        DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite o título do livro:");
        String livro = this.entrada.nextLine().trim();

        System.out.println("Digite o nome do usuário:");
        String usuario = this.entrada.nextLine().trim();

        System.out.println("Digite a data de empréstimo (dd/MM/yyyy):");
        String dataEmprestimoStr = this.entrada.nextLine().trim();
        LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr, formatoHorario);

        System.out.println("Digite a data de devolução (dd/MM/yyyy):");
        String dataDevolucaoStr = this.entrada.nextLine().trim();
        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr, formatoHorario);

        this.biblioteca.newEmprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
        System.out.println("Empréstimo realizado com sucesso!");
        this.entrada.nextLine();
        ;
    }

    public void devolverLivro() {
        this.limparMenu();
        System.out.println("-- Devolver Livro");
        DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite o título do livro a devolver:");
        String titulo = this.entrada.nextLine().trim();

        System.out.println("Digite o nome do usuário que vai devolver:");
        String usuario = this.entrada.nextLine().trim();

        System.out.println("Digite a data de devolução (dd/MM/yyyy). Se for horário atual, pressione 'Enter':");
        String dataDevolucaoStr = this.entrada.nextLine().trim();
        LocalDate dataDevolucao = dataDevolucaoStr.isEmpty()
                ? LocalDate.now()
                : LocalDate.parse(dataDevolucaoStr, formatoHorario);

        this.biblioteca.newDevolucao(titulo, usuario, dataDevolucao);
        System.out.println("Devolução realizada com sucesso!");
        this.entrada.nextLine();
    }

    public void relatorioLivros() {
        this.limparMenu();

        System.out.println("-- Relatório de Livros");
        System.out.println(
                "Livros cadastrados: " + this.biblioteca.getLivros().size() +
                        "\nUsuários cadastrados: " + this.biblioteca.getUsuarios().size() +
                        "\nTotal de empréstimos realizados: " + this.biblioteca.getEmprestimos().length +
                        "\nTotal de devoluções realizadas: " + this.biblioteca.getDevolucoes().length +
                        "\nDevoluções atrasadas: " + this.biblioteca.getDevolucoes().length +
                        "\n\nLivros mais populares: " + this.biblioteca.getLivros().size() +
                        "\nUsuários mais ativos: " + this.biblioteca.getUsuarios().size());

        System.out.println("\nPressione Enter para continuar...");
        this.entrada.reset();
        this.entrada.nextLine();
        this.entrada.nextLine();
    }
}
