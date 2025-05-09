package view;

public class Menu {

    String biblioteca;

    public Menu(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    void limparMenu() {
        System.out.print("\033c");
    }

    void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("3. Emprestar livro");
        System.out.println("4. Devolver livro");
        System.out.println("6. Relatório de livros");
    }
}
