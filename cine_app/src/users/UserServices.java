package users;

import utils.Utils;

import java.util.ArrayList;

public class UserServices {
    public static ArrayList<User> users;

    public void addUser() {
        var name = Utils.stringInput("Ingrese su nombre:");
        var lastName = Utils.stringInput("Ingrese su apellido:");
        // Segurir con los demas datos ...
        // Evaluar la posibilidad de hacer unos métodos de verificación de datos como validators en el package utils

    }

}
