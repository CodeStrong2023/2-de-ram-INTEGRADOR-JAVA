package function;

import auth.SessionUser;
import grid.FunctionGrid;
import menus.AdminFunctionsMenu;
import menus.Menus;
import menus.UserMenu;
import movies.Movie;
import movies.MovieServices;
import utils.Utils;
import utils.enums.MenuName;

import java.util.ArrayList;
import java.util.Objects;

public class FunctionServices {
    public static ArrayList<Function> functions = new ArrayList<>();

    public static void addFunction() {
        Menus.customHeaderMenu("Crear una nueva función de cartelera: ");
        int idMovie = Utils.intInput("Ingrese el id de la película de cartelera: ", MenuName.FUNCTION);
        int room = Utils.intInput("Ingrese el N° de Sala: ", MenuName.FUNCTION);
        int hour = Utils.intInput("Ingrese el horario en hs de 0 a 24: ", MenuName.FUNCTION); // Si hay tiempo se verifica
        int minutes = Utils.intInput("Ingrese el horario en minutos de 0 a 59: ", MenuName.FUNCTION);// Si hay tiempo se verifica
        Movie movie = MovieServices.getMovieById(idMovie, MenuName.FUNCTION);
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
        int functionId = Utils.intInput("Ingrese el ID de la función a editar: ", MenuName.FUNCTION);
        Function function = getFunctionById(functionId);

        Menus.customHeaderMenu("Editar la función");
        int idMovie = Utils.intInput("Ingrese el ID de la película: ", MenuName.FUNCTION);
        Movie movie = MovieServices.getMovieById(idMovie);
        function.setMovie(movie);
        int room = Utils.intInput("Ingrese el número de sala de la película: ", MenuName.FUNCTION);
        function.setRoom(room);
        int hour = Utils.intInput("Ingrese el horario en hs de 0 a 24: ", MenuName.FUNCTION);
        int minutes = Utils.intInput("Ingrese el horario en minutos de 0 a 59: ", MenuName.FUNCTION);
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
        System.out.println("");
        System.out.println("ERROR: No se encontro la función");
        AdminFunctionsMenu.getMenu();
        return null;
    }

    public static void deleteFunction() {
        int id = Utils.intInput("Ingrese el ID de la función que quiere eleminar: ", MenuName.FUNCTION);
        Function function = getFunctionById(id);
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
