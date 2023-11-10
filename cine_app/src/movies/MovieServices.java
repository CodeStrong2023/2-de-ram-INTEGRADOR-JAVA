package movies;

import grid.MovieGrid;
import menus.AdminMovieMenu;
import menus.Menus;
import utils.Utils;
import utils.enums.MenuName;

import java.util.ArrayList;
import java.util.Objects;

public class MovieServices {
    // Lista que almacena todas las películas en el sistema
    public static ArrayList<Movie> movies = new ArrayList<>();
    // Método para agregar una nueva película a la lista
    public static void addMovie() {
        Menus.customHeaderMenu("Agregar una nueva Película");
        String title = Utils.stringInput("Ingrese el título: ", MenuName.MOVIE);
        int classification = Utils.intInput("Ingrese el número de calificación: ", MenuName.MOVIE);
        String gender = Utils.stringInput("Ingrese el género: ", MenuName.MOVIE);
        movies.add(new Movie(title, classification, gender));
        System.out.println("");
        System.out.println("Película agregada exitosamente");
        AdminMovieMenu.getMenu();
    }
    // Método para agregar películas de muestra a la lista
    public static void addMockMovie() {
        movies.add(new Movie("The Equalizer 3", 16, "Acción y aventura"));
        movies.add(new Movie("The Exorcist: Believer", 13, "Terror, Suspenso"));
        movies.add(new Movie("Kandisha", 16, "Terror"));
        movies.add(new Movie("El duelo", 16, "Comedia"));
        movies.add(new Movie("PAW Patrol: The Mighty Movie", 10, "Acción, Aventuras, Animación"));
    }
    // Método para editar la información de una película existente
    public static void editMovie() {
        int id = Utils.intInput("Ingrese el id de la película a editar: ", MenuName.MOVIE);
        Movie movie = getMovieById(id);

        Menus.customHeaderMenu("Ediatar la película " + movie.getTitle());
        String title = Utils.stringInput("Ingrese el título (ingrese NO si no desea editar): ", MenuName.MOVIE);
        if (!title.equalsIgnoreCase("no")) {
            movie.setTitle(title);
        }
        String classification = Utils.stringInput("Ingrese el número de calificación (ingrese NO si no desea editar): ", MenuName.MOVIE);
        if (!classification.equalsIgnoreCase("no")) {
            movie.setClassification(Integer.parseInt(classification));
        }
        String gender = Utils.stringInput("Ingrese el género (ingrese NO si no desea editar): ", MenuName.MOVIE);
        if (!gender.equalsIgnoreCase("no")) {
            movie.setGender(gender);
        }

        System.out.println("");
        System.out.println("Película modificada con éxito");
        AdminMovieMenu.getMenu();

    }
    // Método para obtener una película por su id
    public static Movie getMovieById(int id) {
        for (Movie movie : movies) {
            if (Objects.equals(movie.getId(), id)) {
                return movie;
            }
        }
        System.out.println("");
        System.out.println("ERROR: No se encontro la película con ese ID");
        AdminMovieMenu.getMenu();
        return null;
    }

    // Método para mostrar las películas activas con el formato grid

    public static Movie getMovieById(int id, MenuName menuName) {
        for (Movie movie : movies) {
            if (Objects.equals(movie.getId(), id)) {
                return movie;
            }
        }
        System.out.println("");
        System.out.println("ERROR: No se encontro la película con ese ID");
        Utils.returnMenu(menuName);
        return null;
    }

    public static void deleteMovie() {
        int id = Utils.intInput("Ingrese el ID de la película que quiere eliminar: ", MenuName.MOVIE);
        Movie movie = getMovieById(id);

        movie.setActive(false);
        System.out.println("");
        System.out.println("Película eliminada con éxito");
        AdminMovieMenu.getMenu();
    }


    public static void showMovies(ArrayList<Movie> movies) {
        MovieGrid.generateHeader();
        for (Movie movie : movies) {
            if (movie.isActive()) {
                MovieGrid.showMovieLine(movie);
            }
        }

        AdminMovieMenu.getMenu(SessionUser.user.getName()); //Retorna al menu de admin

        AdminMovieMenu.getMenu();

    }
}
