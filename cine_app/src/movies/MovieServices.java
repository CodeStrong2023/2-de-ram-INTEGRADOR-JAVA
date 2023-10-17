package movies;

import auth.SessionUser;
import menus.AdminMovieMenu;
import menus.Menus;
import utils.Utils;

import java.util.ArrayList;
import java.util.Objects;

public class MovieServices {
    public static ArrayList<Movie> movies = new ArrayList<>();

    public static void addMovie() {
        Menus.customHeaderMenu("Agregar una nueva Película");
        String title = Utils.stringInput("Ingrese el título: ");
        int classification = Utils.intInput("Ingrese en número de calisificación: ");
        String gender = Utils.stringInput("Ingrese el género: ");
        movies.add(new Movie(title, classification, gender));
        System.out.println("Película agregada exitosamente");
    }

    public static void addMockMovie() {
        movies.add(new Movie("The Equalizer 3", 16, "Acción y aventura"));
        movies.add(new Movie("The Exorcist: Believer", 13, "Terror, Suspenso"));
        movies.add(new Movie("Kandisha", 16, "Terror"));
        movies.add(new Movie("El duelo", 16, "Comedia"));
        movies.add(new Movie("PAW Patrol: The Mighty Movie", 1, "Acción, Aventuras, Animación"));
    }

    public static void editMovie() {
        int id = Utils.intInput("Ingrese el id: ");
        Movie movie = getMovieById(id);

        if (movie == null) {
            System.out.println("");
            System.out.println("No se encontro la película");
            AdminMovieMenu.getMenu(SessionUser.user.getName());
        }

        Menus.customHeaderMenu("Ediatar la película " + movie.getTitle());
        String title = Utils.stringInput("Ingrese el título (ingrese NO si no desea editar: )").toLowerCase();
        if (!title.equalsIgnoreCase("no")) {
            movie.setTitle(title);
        }
        String classification = Utils.stringInput("Ingrese el número de calificación (ingrese NO si no desea editar): ").toLowerCase();
        if (!classification.equalsIgnoreCase("no")) {
            movie.setClassification(Integer.parseInt(classification));
        }
        String gender = Utils.stringInput("Ingrese el género (ingrese NO si no desea editar): ").toLowerCase();
        if (!gender.equalsIgnoreCase("no")) {
            movie.setGender(gender);
        }

        AdminMovieMenu.getMenu(SessionUser.user.getName());

    }

    public static Movie getMovieById(int id) {
        for (Movie movie : movies) {
            if (Objects.equals(movie.getId(), id)) {
                return movie;
            }
        }
        return null;
    }

    public static void showMovies() {
        // Desarrollar la lógica con la grid
    }
}
