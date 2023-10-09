package users;

import menus.AdminMenu;
import menus.AdminUserMenu;
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
        String age = Utils.stringInput("Ingrese su edad");
        String email = Utils.stringInput("Ingrese su email");
        String password = Utils.stringInput("Ingrese su password");
        UserServices.users.add(new User(name, lastName, Integer.parseInt(age), email, password));
        System.out.println("Usuario agregado exitosamente");
        AdminUserMenu.getMenu("Luis");

    }

    public static void editUser() {
        String id = Utils.stringInput("Ingrese el id");
        User user = null;
        for (User e : users) {
            if (e.getId() == Integer.parseInt(id)) {
                user = e;
            }
        }
        if (user == null) {
            System.out.println("No se encontro el usuario");
            AdminUserMenu.getMenu("Luis");
        }

        Menus.customHeaderMenu("Ediatar el usuario " + user.getName() + " " + user.getLastName());
        String name = Utils.stringInput("Ingrese su nombre (ingrese NO si no desea editar)");
        if (!name.equalsIgnoreCase("no")) {
            user.setName(name);
        }
        String lastName = Utils.stringInput("Ingresee su apellido (ingrese NO si no desea editar)");
        if (!lastName.equalsIgnoreCase("no")) {
            user.setLastName(lastName);
        }
        String age = Utils.stringInput("Ingrese su edad (ingrese NO si no desea editar)");
        if (!age.equalsIgnoreCase("no")) {
            user.setAge(Integer.parseInt(age));
        }
        String email = Utils.stringInput("Ingrese su email (ingrese NO si no desea editar)");
        if (!email.equalsIgnoreCase("no")) {
            user.setEmai(email);
        }
        String password = Utils.stringInput("Ingrese su password (ingrese NO si no desea editar)");
        if (!password.equalsIgnoreCase("no")) {
            user.setPassword(password);
        }
        AdminUserMenu.getMenu("Luis");

    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        UserServices.users = users;
    }


}
