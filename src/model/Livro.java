package model;

public class Livro {
    private static int contadorCodigo = 1;
    private int codigo;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int exemplaresDisponiveis;
    private String categoria;

    public Livro(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis, String categoria) {
        this.codigo = contadorCodigo++;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Métodos para emprestar e devolver
    public void emprestar() {
        if (exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
        } else {
            throw new IllegalStateException("Nenhum exemplar disponível para empréstimo.");
        }
    }

    public void devolver() {
        exemplaresDisponiveis++;
    }

    // Representação textual do livro
    @Override
    public String toString() {
        return "Livro [Código: " + codigo + ", Título: " + titulo + ", Autor: " + autor +
               ", Ano: " + anoPublicacao + ", Categoria: " + categoria +
               ", Exemplares disponíveis: " + exemplaresDisponiveis + "]";
    }
}
