package test;

import grid.UserGrid;
import users.UserServices;
import utils.Grid;

public class GritTest {
    public static void main(String[] args) {
        UserServices.addMockUser();
//        Grid.userGrid(UserServices.users);
        UserGrid grid = new UserGrid();
        grid.generateHeaders();
        grid.gridUsers(UserServices.users);
    }
}
