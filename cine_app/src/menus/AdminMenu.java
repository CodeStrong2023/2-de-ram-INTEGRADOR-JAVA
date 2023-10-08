package menus;

public class AdminMenu extends Menus {
    private static final AdminMenu instance = new AdminMenu();

    private AdminMenu() {
        super();
    }

    public static void getMenu(String name) {
        instance.adminMenu(name);
    }

    private void adminMenu(String name) {
        Menus.customHeaderMenu("Bienvenido " + name);
        System.out.println("1 - Opciones de películas");
        System.out.println("2 - Opciones de usuarios");
        System.out.println("3 - Opciones de funciones");
        System.out.println("4 - Recaudación");
        System.out.println("5 - Salir");
        setOptionMenu(5);
        this.handleMenuOptions(option);
    }
    private void handleMenuOptions(int option) {
        switch (option) {
            case 1:
                System.out.println("Elejiste la opción 1");
                break;
            case 2:
                System.out.println("Elejiste la opción 2");
                break;
            case 3:
                System.out.println("Elejiste la opción 3");
                break;
            case 4:
                System.out.println("Elejiste la opción 4");
                break;
            case 5:
                System.out.println("Elejiste la opción 5");
                break;
            default:
                System.out.println("Salida");
        }
    }

}
