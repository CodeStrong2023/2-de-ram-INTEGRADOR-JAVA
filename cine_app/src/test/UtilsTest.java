package test;

import utils.Utils;
import utils.enums.MenuName;

public class UtilsTest {
    public static void main(String[] args) {
        String name = Utils.stringInput("Cual es tu nombre?", MenuName.USER);
        System.out.println("El nombre ingresado es: " + name);
        int option = Utils.intInput("Ingrese un número del 1 al 5", MenuName.USER);

        if(option > 5) {
            System.out.println("Te pasaste de 5");
        }
    }
}
