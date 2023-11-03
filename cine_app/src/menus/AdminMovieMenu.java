package menus;

import auth.SessionUser;
import movies.MovieServices;

public class AdminMovieMenu extends Menus {
    private static final AdminMovieMenu instance = new AdminMovieMenu();

    private AdminMovieMenu() {
        super();
    }

    public static void getMenu(String name) {
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
                MovieServices.showMovies(MovieServices.movies);
                break;
            case 2:
                MovieServices.addMovie();
                break;
            case 3:
                MovieServices.editMovie();
                break;
            case 4:
                // Agregar el método de eliminar
                break;
            case 5:
                AdminMenu.getMenu(SessionUser.user.getName());
                break;
            default:
                System.out.println("Salida");
        }
    }
}

