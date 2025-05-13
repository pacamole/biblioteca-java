package model;

public abstract class preCarga {
    public void Carregar(Biblioteca biblioteca) {
        biblioteca.newLivro("Dom Casmurro", "Machado de Assis", 1899, 5, "Romance");
        biblioteca.newLivro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 3, "Fantasia");
        biblioteca.newLivro("A Revolução dos Bichos", "George Orwell", 1945, 4, "Fábula");
        biblioteca.newLivro("1984", "George Orwell", 1949, 2, "Distopia");
        biblioteca.newLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, 6, "Infantil");

        biblioteca.newUsuario("Ana Paula", 99887766, "Rua das Flores, 123", "ana.paula@email.com");
        biblioteca.newUsuario("Bruno Silva", 99776655, "Avenida Brasil, 456", "bruno.silva@email.com");
        biblioteca.newUsuario("Carla Souza", 99665544, "Praça Central, 789", "carla.souza@email.com");
        biblioteca.newUsuario("Diego Lima", 99554433, "Rua do Sol, 321", "diego.lima@email.com");

    }

}