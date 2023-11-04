package auth;

import menus.AdminMenu;
import menus.UserMenu;
import users.User;
import users.UserServices;
import utils.Utils;
import menus.Menus;

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
        int LoginOption = Utils.intInput("Si desea registrarse presione '1', para reintentar '2' o para volver al menú '3': ");
        while(LoginOption <= 3 && LoginOption > 0){
            if(LoginOption == 1){
                UserServices.addUser();
            } else if(LoginOption == 2){
                login();
            } else if(LoginOption == 3){
                Menus.maninMenu();
            }
        }
        while(LoginOption < 1 || LoginOption > 4){
            LoginOption = Utils.intInput("|X| ERROR |X| \nSi desea registrarse presione '1', para reintentar '2' o para volver al menú '3': ");
        }
        while(LoginOption <= 3 && LoginOption >= 1){
            if(LoginOption == 1){
                UserServices.addUser();
            } else if(LoginOption == 2){
                login();
            } else if(LoginOption == 3){
                Menus.maninMenu();
            }
        }
    }
}
