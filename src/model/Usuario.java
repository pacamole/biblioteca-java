package model;

public class Usuario {
    private String nome;
    private int telefone;
    private String endereco;
    private String email;

    public Usuario(String nomes, int telefones, String enderecos, String emails) {
        this.nome = nomes;
        this.telefone = telefones;
        this.endereco = enderecos;
        this.email = emails;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

        public String getEndereco() {
        return endereco;
    }

    public void setEndereço(String endereco) {
        this.endereco = endereco;
    }

        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + ", Telefone: " + telefone+ ", Endereço: " + endereco+ ", Email:" + email;
    }
}
