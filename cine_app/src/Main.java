import function.FunctionServices;
import menus.Menus;
import movies.MovieServices;
import users.UserServices;

public class Main {
    public static void main(String[] args) {
        UserServices.addMockUser();
        MovieServices.addMockMovie();
        FunctionServices.addMockFunction();
        Menus.maninMenu();
    }

}