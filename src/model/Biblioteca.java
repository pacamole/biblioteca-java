package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private String[] livro;
    private ArrayList<Usuario> usuarios;
    private String[] emprestimo;
    private String[] devolucoes;

    public Biblioteca(String[] livros, ArrayList<Usuario> usuarios, String[] emprestimos, String[] devolucoes) {
        this.livro = livros;
        this.usuarios = usuarios;
        this.emprestimo = emprestimos;
        this.devolucoes = devolucoes;
    }

    public void newLivro(String titulo, String autor, int anoPublicacao, int numeroExemplares) {
        // TODO implementar código
        throw new UnsupportedOperationException("Unimplemented method 'newLivro'");
    }

    public void newUsuario(String nome, int telefone, String endereco, String email) {
        Usuario novoUsuario = new Usuario(nome, telefone, endereco, email);
        usuarios.add(novoUsuario); 
    }

    public void newEmprestimo(String livro, String usuarios, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        // TODO implementar código
        throw new UnsupportedOperationException("Unimplemented method 'newEmprestimo'");
    }

    public void newDevolucao(String livro, String usuarios, LocalDate dataDevolucao) {
        // TODO implementar código
        throw new UnsupportedOperationException("Unimplemented method 'newDevolucao'");
    }

    public String[] getLivros() {
        // TODO implementar código
        throw new UnsupportedOperationException("Unimplemented method 'getLivros'");
    }

    public void setLivros(String[] livros) {
        this.livro = livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String[] getEmprestimos() {
        // TODO implementar código
        throw new UnsupportedOperationException("Unimplemented method 'getEmprestimos'");
    }

    public void setEmprestimos(String[] emprestimos) {
        this.livro = emprestimos;
    }

    public String[] getDevolucoes() {
        // TODO implementar código
        throw new UnsupportedOperationException("Unimplemented method 'getDevolucoes'");
    }

    public void setDevolucoes(String[] devolucoes) {
        this.livro = devolucoes;
    }

}
