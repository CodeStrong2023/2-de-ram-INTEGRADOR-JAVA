package menus;

import auth.SessionUser;
import function.FunctionServices;
// Clase que representa el menú de administración de funciones para usuarios con rol de administrador
public class AdminFunctionsMenu extends Menus {
    // Instancia única de la clase para seguir el patrón de diseño Singleton
    private static final AdminFunctionsMenu instance = new AdminFunctionsMenu();
    // Constructor privado para evitar la creación de instancias fuera de la clase
    private AdminFunctionsMenu() {
        super(); // Llama al constructor de la clase base (Menus)
    }

    // Método estático para obtener la instancia única de la clase
    public static void getMenu(String name) {


    public static void getMenu() {

        instance.adminFunctionsMenu();
    }

    // Método privado que define el menú de administración de funciones
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
    // Método privado que maneja las opciones del menú
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
                AdminMenu.getMenu(SessionUser.user.getName()); // Vuelve al menú principal de administrador
                break;
            default:
                System.out.println("Salida"); // Mensaje en caso de opción inválida
        }
    }
}

