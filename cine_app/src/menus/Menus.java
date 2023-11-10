package menus;

import auth.LoginUser;
import users.UserServices;
import utils.Utils;

import java.util.Scanner;

public class Menus {
    protected static int option;
    protected static Scanner scanner = new Scanner(System.in);

    public static void customHeaderMenu(String title) {
        // Este método crea una cabecera de menú flexible, se adapta el tamaño a cualquier título
        String _title = "|          " + title + "          |";
        StringBuilder line = new StringBuilder();

        line.append("=".repeat(_title.length())); // Repite el símbolo del = de acuredo a la longitud del _title
        System.out.println(" ");
        System.out.println(line);
        System.out.println(_title);
        System.out.println(line);
    }

    protected int getOption() {
        return option;
    }

    protected static void setOption(int userOption) {
        option = userOption;
    }

    protected static void setOptionMenu(int maxOptions) {

        System.out.print("Seleccione una opción: ");
        String userOption = scanner.nextLine();

        while (!userOption.matches("\\d+")) {
            System.out.println("");
            System.out.println("Debe ingresar un valor numérico del 1 al " + maxOptions);
            System.out.print("Seleccione una opción: ");
            userOption = scanner.nextLine();

        }

        while (Integer.parseInt(userOption) <= 0 || Integer.parseInt(userOption) > maxOptions) {

            System.out.println("Seleccione una opción válida del 1 al " + maxOptions);
            System.out.print("Seleccione una opción: ");
            userOption = scanner.nextLine();
        }


        setOption(Integer.parseInt(userOption));
    }

    // Métodos de menus
    public static void maninMenu() {
        customHeaderMenu("BIENVENIDOS A CINE APP");
        System.out.println("1 - Login");
        System.out.println("2 - Registrarse");
        System.out.println("3 - Salir");
        setOptionMenu(3);
        handleMenuOptions(option);
    }

    private static void handleMenuOptions(int option) {
        switch (option) {
            case 1:
                LoginUser.login();
                break;
            case 2:
                UserServices.addUser();
                break;
            case 3:
                System.out.println("");
                System.out.println("Gracias por utilizar nuestra Cine App lo esperamos nuevamente");
                System.exit(0);
                break;
            default:
                System.out.println("Salida");
                break;
        }
    }


}
