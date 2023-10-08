package menus;

import java.util.Scanner;

abstract class Menus {
    protected int option;
    protected Scanner scanner = new Scanner(System.in);

    protected void customHeaderMenu(String title) {
        // Este método crea una cabecera de menú flexible, se adapta el tamaño a cualquier título
        String _title = "|          " + title + "          |";
        StringBuilder line = new StringBuilder();

        line.append("=".repeat(_title.length())); // Repite el símbolo del = de acuredo a la longitud del _title
        System.out.println(" ");
        System.out.println(line);
        System.out.println(_title);
        System.out.println(line);
    }

    protected int getOption() {
        return this.option;
    }

    protected void setOption(int option) {
        this.option = option;
    }

    protected void setOptionMenu(int maxOptions) {
        System.out.println("Seleccione una opción: ");
        int userOption = this.scanner.nextInt();
        while (userOption <= 0 || userOption > maxOptions) {
            System.out.println("Seleccione una opción válida del 1 al " + maxOptions);
            System.out.println("Seleccione una opción: ");
            userOption = this.scanner.nextInt();

        }
        this.setOption(userOption);
    }

    // Métodos de menus
    protected void maninMenu() {
        this.customHeaderMenu("BIENVENIDOS A CINE APP");
        System.out.println("1 - Login");
        System.out.println("2 - Registrarse");
        System.out.println("3 - Salir");
        this.setOptionMenu(3);

    }


}
