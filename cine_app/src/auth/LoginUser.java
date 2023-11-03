package auth;

import menus.AdminMenu;
import menus.UserMenu;
import users.User;
import users.UserServices;
import utils.Utils;

public class LoginUser {

    public static void login() {
        System.out.println("");
        String email = Utils.stringInput("Ingrese su emai: ");
        String password = Utils.stringInput("Ingrese su password: ");
        User user = UserServices.getUserByEmail(email);
        if (user != null) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                SessionUser.setSessionUser(user); // Seteamos el user en la session
                if (user.getRole().equals("admin")) { // Chequeamos si es el usuario admin y determinamos a que menú se redirige
                    AdminMenu.getMenu(user.getName());
                } else {
                    UserMenu.getMenu(user.getName());
                }
                return;
            }

        }
        System.out.println("");
        System.out.println("Email o contraseña no válida");
        login();
    }
}
