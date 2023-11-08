package utils;

import auth.SessionUser;
import menus.*;
import utils.enums.MenuName;

import java.util.Scanner;

public class Utils {

    public static Scanner scanner = new Scanner(System.in);

    /*
    * Método stringInput:
    * - String message: es el mensaje que va a mostrar en la pantalla para orientar al usuario el dato a ingresar
    * - String menu: es el dato que necesitamos para saber a que menú se va a redirgir en caso de que el usuario ingrese N (ver returnMenu() )
    * */
    public static String stringInput(String message, MenuName menuName) {
        System.out.println("Ingresar (N) para volver al menú anterior");
        System.out.print(message);
        String data = scanner.nextLine();
        if(data.equalsIgnoreCase("n")) {
            returnMenu(menuName);
            scanner.close();
        }

        return data;
    }

    public static int intInput(String message) {
        System.out.print(message);
        int resp = Integer.parseInt(Utils.scanner.nextLine());
        return resp;
    }

    public static int intInputCheck(String message) {
        System.out.println("Debe ingresar un valor numérico o (N) para volve");
        System.out.print(message);
        String option = scanner.nextLine();
        while (!option.matches("\\d+") && !option.equalsIgnoreCase("n")) {
            System.out.println("");
            System.out.println("Debe ingresar un valor numérico o (N) para volve");
            System.out.print(message);
            option = scanner.nextLine();
        }

        if (option.equalsIgnoreCase("n")) {
            return 0;
        }

        return Integer.parseInt(option);
    }

    // Este método designa a que menú retorna de a cuerdo a lo que se seteo en cada input
    private static void returnMenu(MenuName menuName) {
        switch (menuName) {
            case USER:
                Menus.maninMenu();
                break;
            case USER_ADMIN:
                AdminUserMenu.getMenu();
                break;
            case MOVIE:
                AdminMovieMenu.getMenu();
                break;
            case FUNCTION:
                AdminFunctionsMenu.getMenu();
                break;
            default:
                AdminMenu.getMenu(SessionUser.user.getName());
                break;
        }
    }

}
