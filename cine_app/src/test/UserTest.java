package test;

import users.User;
import users.UserServices;
import utils.Utils;

public class UserTest {
    public static void main(String[] args) {
//        var name = Utils.stringInput("Ingrese nombre");
//        var age = Utils.intInput("Ingrese edad");
//        var email = Utils.stringInput("Ingrese email");
//        System.out.println("email = " + email);
//        System.out.println(name);
//        System.out.println("age = " + age);
//        User user1 = new User(name, "Mera", 23, "dfs", "123", "admin");
//        System.out.println(user1.getName());

    UserServices.addUser();
    UserServices.addUser();

    }
}
