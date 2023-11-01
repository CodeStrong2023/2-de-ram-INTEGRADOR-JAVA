package menus;

import auth.SessionUser;
import users.UserServices;

public class AdminUserMenu extends Menus {
    private static final AdminUserMenu instance = new AdminUserMenu();

    private AdminUserMenu() {
        super();
    }

    public static void getMenu(String name) {
        instance.adminUserMenu();
    }

    private void adminUserMenu() {
        super.customHeaderMenu("ADMINISTRACIÓN DE USUARIOS");
        System.out.println("1 - Mostrar todos los usuarios");
        System.out.println("2 - Agregar un usuario");
        System.out.println("3 - Editar un usuario");
        System.out.println("4 - Eliminar un usuario");
        System.out.println("5 - Volver");
        super.setOptionMenu(5);
        this.handleMenuOptions(super.option);

    }

    private void handleMenuOptions(int option) {
        switch (option) {
            case 1:
                UserServices.showUsers();
                break;
            case 2:
                UserServices.addUser();
                break;
            case 3:
                UserServices.editUser();
                break;
            case 4:
                //Agregar el método de eliminar
                break;
            case 5:
                AdminMenu.getMenu(SessionUser.user.getName());
                break;
            default:
                System.out.println("Salida");
        }
    }
}

