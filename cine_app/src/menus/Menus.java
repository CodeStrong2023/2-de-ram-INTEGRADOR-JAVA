package menus;

import java.util.Scanner;

public class Menus {
    static int option;
    static Scanner scanner = new Scanner(System.in);

    public static void customHeaderMenu(String title) {
        // Este método crea una cabecera de menú flexible, se adapta el tamaño a cualquier título
        String _title = "|          " + title + "          |";
        StringBuilder line = new StringBuilder();

        for (var i = 0; i < _title.length(); i++) {
            line.append("=");
        }
        System.out.println("");
        System.out.println(line);
        System.out.println(_title);
        System.out.println(line);
    }

    public static int getOption() {
        return option;
    }

    public static void setOption(int option) {
        Menus.option = option;
    }

    public static void setOptionMenu(int maxOptions) {
        System.out.println("Seleccione una opción: ");
        int userOption = Menus.scanner.nextInt();
        while (userOption <= 0 || userOption > maxOptions) {
            System.out.println("Seleccione una opción válida del 1 al " + maxOptions);
            System.out.println("Seleccione una opción: ");
            userOption = Menus.scanner.nextInt();

        }
        Menus.setOption(userOption);
    }
    // Métodos de menus
    public static void maninMenu() {
        Menus.customHeaderMenu("BIENVENIDOS A CINE APP");
        System.out.println("1 - Login");
        System.out.println("2 - Registrarse");
        System.out.println("3 - Salir");
        Menus.setOptionMenu(3);

    }

    public static void userMenu(String name) {
        Menus.customHeaderMenu("Bienvenido " + name);
        System.out.println("1 - Comprar una entrada");
        System.out.println("2 - Mostrar las funciones");
        System.out.println("3 - Salir");
        Menus.setOptionMenu(3);
    }
    public static void adminMenu(String name) {
        Menus.customHeaderMenu("Bienvenido " + name);
        System.out.println("1 - Opciones de películas");
        System.out.println("2 - Opciones de usuarios");
        System.out.println("3 - Opciones de funciones");
        System.out.println("4 - Recaudación");
        System.out.println("5 - Salir");
        Menus.setOptionMenu(5);
    }

    public static void adminMoviesMenu() {
        Menus.customHeaderMenu("ADMINISTRACIÓN DE PELICULAS");
        System.out.println("1 - Mostrar todas las películas");
        System.out.println("2 - Agregar una película");
        System.out.println("3 - Editar una película");
        System.out.println("4 - Eliminar una película");
        System.out.println("5 - Volver");
        Menus.setOptionMenu(5);
    }
    public static void adminUsersMenu() {
        Menus.customHeaderMenu("ADMINISTRACIÓN DE USUARIOS");
        System.out.println("1 - Mostrar todos los usuarios");
        System.out.println("2 - Agregar un usuario");
        System.out.println("3 - Editar un usuario");
        System.out.println("4 - Eliminar un usuario");
        System.out.println("5 - Volver");
        Menus.setOptionMenu(5);
    }
     public static void adminFunctionsMenu() {
        Menus.customHeaderMenu("ADMINISTRACIÓN DE FUNCIONES");
        System.out.println("1 - Mostrar todas las funciones");
        System.out.println("2 - Agregar una función");
        System.out.println("3 - Editar una función");
        System.out.println("4 - Eliminar una función");
        System.out.println("5 - Volver");
        Menus.setOptionMenu(5);
    }
}
