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
    // Lista que almacena instancias de la clase Function para gestionar funciones de cartelera
    public static ArrayList<Function> functions = new ArrayList<>();

    // Método para agregar una nueva función a la lista de funciones
    public static void addFunction(){
        //Solicitamos los datos de la funcion a agregar
        Menus.customHeaderMenu("Crear una nueva función de cartelera: ");
        int idMovie = Utils.intInput("Ingrese el id de la película de cartelera: ");
        int room = Utils.intInput("Ingrese el N° de Sala: ");
        int hour = Utils.intInput("Ingrese el horario en hs de 0 a 24: "); // Si hay tiempo se verifica
        int minutes = Utils.intInput("Ingrese el horairo en minutos de 0 a 59: ");// Si hay tiempo se verifica


        Movie movie = MovieServices.getMovieById(idMovie);
        // Seteamos la película


    public static void addFunction() {
        Menus.customHeaderMenu("Crear una nueva función de cartelera: ");
        int idMovie = Utils.intInput("Ingrese el id de la película de cartelera: ", MenuName.FUNCTION);
        int room = Utils.intInput("Ingrese el N° de Sala: ", MenuName.FUNCTION);
        int hour = Utils.intInput("Ingrese el horario en hs de 0 a 24: ", MenuName.FUNCTION);
        while (hour < 0 || hour > 24) {
            System.out.println("ERROR: debe ingresar un número entre 0 a 24 para indicar la hora");
            hour = Utils.intInput("Ingrese el horario en hs de 0 a 24: ", MenuName.FUNCTION);
        }
        int minutes = Utils.intInput("Ingrese el horario en minutos de 0 a 59: ", MenuName.FUNCTION);
        while (minutes < 0 || minutes > 59) {
            System.out.println("ERROR: debe ingresar un número entre 0 a 59 para indicar los minutos");
            minutes = Utils.intInput("Ingrese el horario en minutos de 0 a 59: ", MenuName.FUNCTION);
        }
        Movie movie = MovieServices.getMovieById(idMovie, MenuName.FUNCTION);

        functions.add(new Function(movie, room, hour, minutes));
        System.out.println("");
        System.out.println("Función agregada con éxito");

        AdminFunctionsMenu.getMenu(SessionUser.user.getName());

    }
    //Hardcodeamos algunas funciones
    public static void addMockFunction(){

        AdminFunctionsMenu.getMenu();
    }

    public static void addMockFunction() {


        functions.add(new Function(MovieServices.movies.get(0), 3, 12, 30));
        functions.add(new Function(MovieServices.movies.get(1), 5, 15, 30));
        functions.add(new Function(MovieServices.movies.get(2), 1, 20, 30));
    }

    //Método para editar una función existente en la lista
    public static void editFunction(){
        // Solicitamos al usuario el ID de la función que desea editar
        int functionId = Utils.intInput("Ingrese el id: ");
        Function function = getFunctionById(functionId);
        //Verificamos que la funcion exista
        if(function == null) {
            System.out.println("");
            System.out.println("No se encontro la función");
            AdminFunctionsMenu.getMenu(SessionUser.user.getName());
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

    //Metodo para mostrar la funcion en base al ID proporcionado
    public static Function getFunctionById(int id){
        for(Function function: functions) {
            if(Objects.equals(function.getId(), id)) {


    public static Function getFunctionById(int id) {
        for (Function function : functions) {

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

    // Método para mostrar todas las funciones en la consola
    public static void showFunctions(){



    public static void showFunctions() {

        FunctionGrid.generateHeader();
        for (Function function : functions) {
            if (function.isActive()) {
                FunctionGrid.showFunctionLine(function);
            }
        }

        // Mostrar el menú correspondiente según el rol del usuario
        if(SessionUser.user.getRole().equals("admin")) {
            AdminFunctionsMenu.getMenu(SessionUser.user.getName());

        if (SessionUser.user.getRole().equals("admin")) {
            AdminFunctionsMenu.getMenu();

        } else {
            UserMenu.getMenu(SessionUser.user.getName());
        }
    }
}
