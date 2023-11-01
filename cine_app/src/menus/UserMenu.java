package menus;

import auth.SessionUser;
import function.FunctionServices;
import ticket.TicketServices;

public class UserMenu extends Menus {
    private static final UserMenu instance = new UserMenu();

    private UserMenu() {
        super();
    }

    public static void getMenu(String name) {
        instance.userMenu(name);
    }

    private void userMenu(String name) {
        super.customHeaderMenu("Bienvenido " + name);
        System.out.println("1 - Comprar una entrada");
        System.out.println("2 - Mostrar las funciones");
        System.out.println("3 - Salir");
        super.setOptionMenu(3);
        handleMenuOptions(super.option);
    }

    private void handleMenuOptions(int option) {
        switch (option) {
            case 1:
                TicketServices.purchaseTicket();
                break;
            case 2:
                FunctionServices.showFunctions();
                break;
            case 3:
                Menus.maninMenu();
                break;
            default:
                System.out.println("Salida");
        }
    }
}
