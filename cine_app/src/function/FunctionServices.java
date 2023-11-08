package function;

import auth.SessionUser;
import grid.FunctionGrid;
import menus.AdminFunctionsMenu;
import menus.Menus;
import menus.UserMenu;
import movies.Movie;
import movies.MovieServices;
import utils.Utils;

import java.util.ArrayList;
import java.util.Objects;

public class FunctionServices {
    public static ArrayList<Function> functions = new ArrayList<>();

    public static void addFunction() {
        Menus.customHeaderMenu("Crear una nueva función de cartelera: ");
        int idMovie = Utils.intInput("Ingrese el id de la película de cartelera: ");
        int room = Utils.intInput("Ingrese el N° de Sala: ");
        int hour = Utils.intInput("Ingrese el horario en hs de 0 a 24: "); // Si hay tiempo se verifica
        int minutes = Utils.intInput("Ingrese el horario en minutos de 0 a 59: ");// Si hay tiempo se verifica
        Movie movie = MovieServices.getMovieById(idMovie);
        functions.add(new Function(movie, room, hour, minutes));
        System.out.println("");
        System.out.println("Función agregada con éxito");
        AdminFunctionsMenu.getMenu();
    }

    public static void addMockFunction() {

        functions.add(new Function(MovieServices.movies.get(0), 3, 12, 30));
        functions.add(new Function(MovieServices.movies.get(1), 5, 15, 30));
        functions.add(new Function(MovieServices.movies.get(2), 1, 20, 30));
    }

    public static void editFunction() {
        int functionId = Utils.intInputCheck("Ingrese el ID de la función a editar: ");
        if (functionId == 0) {
            AdminFunctionsMenu.getMenu();
        }
        Function function = getFunctionById(functionId);
        if (function == null) {
            System.out.println("");
            System.out.println("No se encontro la función");
            AdminFunctionsMenu.getMenu();
        }

        Menus.customHeaderMenu("Editar la función");
        int idMovie = Utils.intInput("Ingrese el ID de la película: ");
        Movie movie = MovieServices.getMovieById(idMovie);
        function.setMovie(movie);
        int room = Utils.intInput("Ingrese el número de sala de la película: ");
        function.setRoom(room);
        int hour = Utils.intInput("Ingrese el horario en hs de 0 a 24: ");
        int minutes = Utils.intInput("Ingrese el horario en minutos de 0 a 59: ");
        function.setSchedule(hour, minutes);
        System.out.println("");
        System.out.println("Función editada con éxito");
        AdminFunctionsMenu.getMenu();
    }

    public static Function getFunctionById(int id) {
        for (Function function : functions) {
            if (Objects.equals(function.getId(), id)) {
                return function;
            }
        }
        return null;
    }

    public static void deleteFunction() {
        int id = Utils.intInput("Ingrese el ID de la función que quiere eleminar: ");
        Function function = getFunctionById(id);
        if (function == null) {
            System.out.println("");
            System.out.println("No se encontó la función con ese ID");
            AdminFunctionsMenu.getMenu();
        }
        function.setActive(false);
        System.out.println("");
        System.out.println("La función se eliminó con éxito");
        AdminFunctionsMenu.getMenu();
    }

    public static void showFunctions() {
        FunctionGrid.generateHeader();
        for (Function function : functions) {
            if (function.isActive()) {
                FunctionGrid.showFunctionLine(function);
            }
        }
        if (SessionUser.user.getRole().equals("admin")) {
            AdminFunctionsMenu.getMenu();
        } else {
            UserMenu.getMenu(SessionUser.user.getName());
        }
    }
}
