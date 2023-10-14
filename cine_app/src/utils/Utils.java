package utils;

import java.util.Scanner;

public class Utils {
    public static Scanner scanner = new Scanner(System.in);

    public static String stringInput(String message) {
        System.out.println(message);
        return Utils.scanner.nextLine();
    }

}
