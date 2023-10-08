package menus;

public class AdminMovieMenu extends Menus {
    private static  final AdminMovieMenu instance = new AdminMovieMenu();
    private AdminMovieMenu() {
        super();
    }

    public static void getMenu(String name){
        instance.adminMoviesMenu();
    }
     private void adminMoviesMenu() {
        super.customHeaderMenu("ADMINISTRACIÓN DE PELICULAS");
        System.out.println("1 - Mostrar todas las películas");
        System.out.println("2 - Agregar una película");
        System.out.println("3 - Editar una película");
        System.out.println("4 - Eliminar una película");
        System.out.println("5 - Volver");
        super.setOptionMenu(5);
        handleMenuOptions(super.option);
    }

    private void handleMenuOptions(int option) {
        switch (option) {
            case 1:
                System.out.println("Elejiste la opción 1");
                break;
            case 2:
                System.out.println("Elejiste la opción 2");
                break;
            case 3:
                System.out.println("Elejiste la opción 3");
                break;
            default:
                System.out.println("Salida");
        }
    }
}

