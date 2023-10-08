package menus;

public class AdminFunctionsMenu extends Menus {
    private static  final AdminFunctionsMenu instance = new AdminFunctionsMenu();
    private AdminFunctionsMenu() {
        super();
    }

    public static void getMenu(String name){
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

