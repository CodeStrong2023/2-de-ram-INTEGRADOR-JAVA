package menus;

public class UserMenu extends Menus {
    private static  final UserMenu instance = new UserMenu();
    private UserMenu() {
        super();
    }

    public static void getMenu(String name){
        instance.userMenu(name);
    }
     private void userMenu(String name) {
        Menus.customHeaderMenu("Bienvenido " + name);
        System.out.println("1 - Comprar una entrada");
        System.out.println("2 - Mostrar las funciones");
        System.out.println("3 - Salir");
        setOptionMenu(3);
        handleMenuOptions(option);
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
            default:
                System.out.println("Salida");
        }
    }
}
