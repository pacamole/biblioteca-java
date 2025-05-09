import model.Biblioteca;
import view.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("| Olá usuário! Te desejo boas vindas ao sistema de controle de biblioteca! |");
        System.out.println("+--------------------------------------------------------------------------+");

        Biblioteca biblioteca = new Biblioteca(new String[0], new String[0], new String[0], new String[0]);

        Menu menu = new Menu(biblioteca);
        menu.iniciarMenu();

        System.out.println("Obrigado por usar o sistema de controle de biblioteca!");
    }
}
