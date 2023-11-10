package menus;

import auth.SessionUser;
// Clase que representa el menú principal para usuarios administradores
public class AdminMenu extends Menus {
    private static final AdminMenu instance = new AdminMenu();
    private AdminMenu() {
        super();
    }
    public static void getMenu(String name) {
        instance.adminMenu(name);
    }

    // Método privado que define el menú principal para usuarios administradores
    private void adminMenu(String name) {
        super.customHeaderMenu("Bienvenido " + name);
        System.out.println("1 - Opciones de películas");
        System.out.println("2 - Opciones de usuarios");
        System.out.println("3 - Opciones de funciones");
        System.out.println("4 - Salir");
        super.setOptionMenu(4);
        this.handleMenuOptions(super.option);
    }
    //A traves de un switch case tomamos la opcion seleccionada por el usuario para redireccionarlo
    private void handleMenuOptions(int option) {
        switch (option) {
            case 1:
                AdminMovieMenu.getMenu(SessionUser.user.getName());
                break;
            case 2:
                AdminUserMenu.getMenu(SessionUser.user.getName());
                break;
            case 3:
                AdminFunctionsMenu.getMenu(SessionUser.user.getName());
                break;
            case 4:
                SessionUser.setSessionUser(null);
                Menus.maninMenu();
             break;
            default:
                System.out.println("Salida");
        }
    }

}
