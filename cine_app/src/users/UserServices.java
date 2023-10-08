package users;

import menus.Menus;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

public class UserServices {
    private static ArrayList<User> users = new ArrayList<>();

    public static void addUser() {
        // Evaluar la posibilidad de hacer unos métodos de verificación de datos como validators en el package utils
        Menus.customHeaderMenu("Agregar un usuario nuevo");
        String name = Utils.stringInput("Ingrese su nombre");
        String lastName = Utils.stringInput("Ingresee su apellido");
        String email = Utils.stringInput("Ingrese su email");
        String password = Utils.stringInput("Ingrese su password");
        String role = Utils.stringInput("Ingrese su rol");
        String age = Utils.stringInput("Ingrese su edad");
        UserServices.users.add(new User(name, lastName, Integer.parseInt(age), email, password, role));
        for(User e : users){
            System.out.println("e = " + e.getId());
        }
    }

    public static void editUser(int id) {
        User user;
        for( User e : users) {
            if(e.getAge() == id) {
                user = e;
            }
        }


    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        UserServices.users = users;
    }


}
