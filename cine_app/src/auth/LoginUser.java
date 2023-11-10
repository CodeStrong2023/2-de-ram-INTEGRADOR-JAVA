package auth;

import menus.AdminMenu;
import menus.UserMenu;
import users.User;
import users.UserServices;
import utils.Utils;
import menus.Menus;
import utils.enums.MenuName;

public class LoginUser {

    public static void login() {
        System.out.println("");

        // Solicitamos al usuario que ingrese su correo electrónico y contraseña
        String email = Utils.stringInput("Ingrese su email: ");
        String password = Utils.stringInput("Ingrese su password: ");

        // Obtenemos la información del usuario utilizando el servicio UserServices
        String email = Utils.stringInput("Ingrese su emai: ", MenuName.USER);
        String password = Utils.stringInput("Ingrese su password: ", MenuName.USER);

        User user = UserServices.getUserByEmail(email);

        // Verificamos la información del usuario utilizando el servicio UserServices
        if (user != null) {
            // Verifica si las credenciales ingresadas coinciden con las del usuario
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                SessionUser.setSessionUser(user); // Seteamos el user en la session
                if (user.getRole().equals("admin")) { // Chequeamos si es el usuario admin y determinamos a que menú se redirige
                    AdminMenu.getMenu(user.getName());
                } else {
                    UserMenu.getMenu(user.getName());
                }
                // Salir del método después de un inicio de sesión exitoso
                return;
            }

        }
        // Mostramos un mensaje de error y se reinicia el proceso de inicio de sesión si las credenciales son inválidas
        System.out.println("");
        System.out.println("Email o contraseña no válida");
        Menus.maninMenu();

    }
}
