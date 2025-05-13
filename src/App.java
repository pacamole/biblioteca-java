import java.util.Scanner;

import model.Biblioteca;
import model.preCarga;
import view.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        new preCarga() {
        }.Carregar(biblioteca);


        System.out.println("\n\n+--------------------------------------------------------------------------+");
        System.out.println("| Olá usuário! Te desejo boas vindas ao sistema de controle de biblioteca! |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("\nPressione enter para continuar...");
        entrada.nextLine();
        entrada.reset();


        Menu menu = new Menu(biblioteca, entrada);
        menu.iniciarMenu();

        System.out.println("Obrigado por usar o sistema de controle da biblioteca!");
    }
}
