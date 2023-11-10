package test;

import function.FunctionServices;
import grid.FunctionGrid;
import grid.MovieGrid;
import movies.MovieServices;
import users.UserServices;

public class GritTest {
    public static void main(String[] args) {
        UserServices.addMockUser();
//        Grid.userGrid(UserServices.users);
//        UserGrid grid = new UserGrid();
//        grid.generateHeaders();
//        grid.gridUsers(UserServices.users);
//        UserServices.users.get(0);
//        UserGrid2 grid2 = new UserGrid2();
//        grid2.generateHeaders();
//        grid2.showUsers(UserServices.users);
        MovieServices.addMockMovie();
//        MovieGrid.generateHeader();
//        MovieGrid.showMovieLine(MovieServices.movies.get(0));
        FunctionServices.addMockFunction();
        FunctionGrid.generateHeader();
        FunctionGrid.showFunctionLine(FunctionServices.functions.get(0));

    }
}
