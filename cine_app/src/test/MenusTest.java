package test;


import auth.LoginUser;
import menus.AdminUserMenu;
import menus.Menus;
import menus.UserMenu;
import movies.MovieServices;
import users.User;
import users.UserServices;

import java.awt.*;

public class MenusTest {

    public static void main(String[] args) {
//        AdminUserMenu.getMenu("Luis");
        UserServices.addMockUser();
        MovieServices.addMockMovie();
        Menus.maninMenu();
    }
}
