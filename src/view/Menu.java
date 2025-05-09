package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Biblioteca;

public class Menu {

    Biblioteca biblioteca;

    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
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
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        String mensagem = "";

        while (opcao != 6) {
            this.limparMenu();

            if (!mensagem.isEmpty()) {
                System.out.println(mensagem);
                mensagem = "";
            }

            this.mostrarMenu();

            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrarLivro();
                    break;
                case 2:
                    this.cadastrarUsuario();
                    break;
                case 3:
                    this.emprestarLivro();
                    break;
                case 4:
                    this.devolverLivro();
                    break;
                case 5:
                    this.relatorioLivros();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    entrada.close();

                    break;
                default:
                    mensagem = "Opção inválida! Tente novamente.";
                    break;
            }
        }
    }

    public void cadastrarLivro() {
        this.limparMenu();
        System.out.println("-- Cadastrar Livro");
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o título do livro:");
        String titulo = entrada.nextLine().trim();

        System.out.println("Digite o autor do livro:");
        String autor = entrada.nextLine().trim();

        System.out.println("Digite o ano de publicação do livro:");
        int anoPublicacao = entrada.nextInt();

        System.out.println("Digite o número de exemplares disponíveis:");
        int numeroExemplares = entrada.nextInt();

        this.biblioteca.newLivro(titulo, autor, anoPublicacao, numeroExemplares);
        System.out.println("Livro cadastrado com sucesso!");
        entrada.nextLine();
        entrada.close();
    }

    public void cadastrarUsuario() {
        this.limparMenu();
        System.out.println("-- Cadastrar Usuário");
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do usuário:");
        String nome = entrada.nextLine().trim();

        System.out.println("Digite o idade do usuário:");
        int telefone = entrada.nextInt();

        this.biblioteca.newUsuario(nome, telefone);
        System.out.println("Usuário cadastrado com sucesso!");
        entrada.nextLine();
        entrada.close();
    }

    public void emprestarLivro() {
        this.limparMenu();
        System.out.println("-- Emprestar Livro");
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite o título do livro:");
        String livro = entrada.nextLine().trim();

        System.out.println("Digite o nome do usuário:");
        String usuario = entrada.nextLine().trim();

        System.out.println("Digite a data de empréstimo (dd/MM/yyyy):");
        String dataEmprestimoStr = entrada.nextLine().trim();
        LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr, formatoHorario);

        System.out.println("Digite a data de devolução (dd/MM/yyyy):");
        String dataDevolucaoStr = entrada.nextLine().trim();
        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr, formatoHorario);

        this.biblioteca.newEmprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
        System.out.println("Empréstimo realizado com sucesso!");
        entrada.nextLine();
        entrada.close();
    }

    public void devolverLivro() {
        this.limparMenu();
        System.out.println("-- Devolver Livro");
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite o título do livro a devolver:");
        String titulo = entrada.nextLine().trim();

        System.out.println("Digite o nome do usuário que vai devolver:");
        String usuario = entrada.nextLine().trim();

        System.out.println("Digite a data de devolução (dd/MM/yyyy). Se for horário atual, pressione 'Enter':");
        String dataDevolucaoStr = entrada.nextLine().trim();
        LocalDate dataDevolucao = dataDevolucaoStr.isEmpty()
                ? LocalDate.now()
                : LocalDate.parse(dataDevolucaoStr, formatoHorario);

        this.biblioteca.newDevolucao(titulo, usuario, dataDevolucao);
        System.out.println("Devolução realizada com sucesso!");
        entrada.nextLine();
        entrada.close();
    }

    public void relatorioLivros() {
        this.limparMenu();
        System.out.println("-- Relatório de Livros");
        System.out.println(
                "Livros cadastrados: " + this.biblioteca.getLivros().length +
                        "\nUsuários cadastrados: " + this.biblioteca.getUsuarios().length +
                        "\nTotal de empréstimos realizados: " + this.biblioteca.getEmprestimos().length +
                        "\nTotal de devoluções realizadas: " + this.biblioteca.getDevolucoes().length +
                        "\nDevoluções atrasadas: " + this.biblioteca.getDevolucoes().length +
                        "\n\nLivros mais populares: " + this.biblioteca.getLivros().length +
                        "\nUsuários mais ativos: " + this.biblioteca.getUsuarios().length);
    }
}
