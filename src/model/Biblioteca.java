package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private Livro[] livro;
    private ArrayList<Usuario> usuarios;
    private String[] emprestimo;
    private String[] devolucoes;

    // ✅ Lista de livros usando a nova classe Livro
    private ArrayList<Livro> livros = new ArrayList<>();

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimo = new String[0];
        devolucoes = new String[0];
    }

    // ✅ Método para adicionar um livro
    public void newLivro(String titulo, String autor, int anoPublicacao, int numeroExemplares, String categoria) {
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao, numeroExemplares, categoria);
        livros.add(novoLivro);
    }

    // ✅ Método para retornar os livros cadastrados
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void newUsuario(String nome, int telefone, String endereco, String email) {
        Usuario novoUsuario = new Usuario(nome, telefone, endereco, email);
        usuarios.add(novoUsuario);
    }

    public void newEmprestimo(String livro, String usuarios, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        // TODO implementar código
        // throw new UnsupportedOperationException("Unimplemented method
        // 'newEmprestimo'");
    }

    public void newDevolucao(String livro, String usuarios, LocalDate dataDevolucao) {
        // TODO implementar código
        // throw new UnsupportedOperationException("Unimplemented method
        // 'newDevolucao'");
    }

    public String[] getLivrosAntigo() {
        return new String[] { "" };
        // TODO implementar código
        // throw new UnsupportedOperationException("Unimplemented method 'getLivros'");
    }

    public void setLivros(Livro[] livros) {
        this.livro = livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String[] getEmprestimos() {
        return new String[] { "" };
        // TODO implementar código
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getEmprestimos'");
    }

    public void setEmprestimos(String[] emprestimos) {
        this.emprestimo = emprestimos;
    }

    public String[] getDevolucoes() {
        return new String[] { "" };
        // TODO implementar código
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getDevolucoes'");
    }

    public void setDevolucoes(String[] devolucoes) {
        this.devolucoes = devolucoes;
    }
}
