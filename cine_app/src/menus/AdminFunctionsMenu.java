package menus;

import auth.SessionUser;
import function.FunctionServices;

public class AdminFunctionsMenu extends Menus {
    private static final AdminFunctionsMenu instance = new AdminFunctionsMenu();

    private AdminFunctionsMenu() {
        super();
    }

    public static void getMenu(String name) {
        instance.adminFunctionsMenu();
    }

    private void adminFunctionsMenu() {
        super.customHeaderMenu("ADMINISTRACIÓN DE FUNCIONES");
        System.out.println("1 - Mostrar todas las funciones");
        System.out.println("2 - Agregar una función");
        System.out.println("3 - Editar una función");
        System.out.println("4 - Eliminar una función");
        System.out.println("5 - Volver");
        super.setOptionMenu(5);
        this.handleMenuOptions(super.option);
    }

    private void handleMenuOptions(int option) {
        switch (option) {
            case 1:
                FunctionServices.showFunctions();
                break;
            case 2:
                FunctionServices.addFunction();
                break;
            case 3:
                FunctionServices.editFunction();
                break;
            case 4:
                FunctionServices.deleteFunction();
                break;
            case 5:
                AdminMenu.getMenu(SessionUser.user.getName());
                break;
            default:
                System.out.println("Salida");
        }
    }
}

