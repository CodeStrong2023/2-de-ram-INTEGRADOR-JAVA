package test;

import grid.UserGrid;
import grid.UserGrid2;
import users.UserServices;
import utils.Grid;

public class GritTest {
    public static void main(String[] args) {
        UserServices.addMockUser();
//        Grid.userGrid(UserServices.users);
//        UserGrid grid = new UserGrid();
//        grid.generateHeaders();
//        grid.gridUsers(UserServices.users);
        UserServices.users.get(0);
        UserGrid2 grid2 = new UserGrid2();
        grid2.generateHeaders();
        grid2.showUsers(UserServices.users);
    }
}
