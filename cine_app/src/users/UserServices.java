package users;

import auth.SessionUser;
import grid.UserGrid;
import menus.AdminUserMenu;
import menus.Menus;
import utils.Utils;
import utils.enums.MenuName;

import java.util.ArrayList;
import java.util.Objects;

public class UserServices {
    public static ArrayList<User> users = new ArrayList<>();

    public static void addUser() {
        // Verificamos el tipo de usuario
        String userType = SessionUser.user.getRole();
        // Determinamos el enum dependiendo el tipo de usuario para enviar en los input
        MenuName menu = userType.equals("user") ? MenuName.USER : MenuName.USER_ADMIN;

        Menus.customHeaderMenu("Agregar un usuario nuevo");
        String name = Utils.stringInput("Ingrese su nombre: ", menu);
        String lastName = Utils.stringInput("Ingrese su apellido: ", menu);
        int age = Utils.intInput("Ingrese su edad: ", menu);
        String email = Utils.stringInput("Ingrese su email: ", menu);
        String password = Utils.stringInput("Ingrese su password: ", menu);
        // Queda pendiente la opción de agregar otro usuario admin
       /* if(userType.equalsIgnoreCase("admin")) {
            String role = Utils.stringInput("")
        }*/
        users.add(new User(name, lastName, age, email, password));
        System.out.println("");
        System.out.println("Usuario agregado exitosamente");

        // Verificamos el tipo de usuario para determinar a que ménu retorna
        if (userType.equalsIgnoreCase("user")) {
            Menus.maninMenu();
        } else {
            AdminUserMenu.getMenu();
        }


    }

    public static void addMockUser() {
        users.add(new User("Admin", "", 37, "a", "a", "admin"));
        users.add(new User("Juan", "Perez", 22, "jp@gmail.com", "123"));
        users.add(new User("Mariana", "Diaz", 25, "md@gmail.com", "123"));
    }

    public static void editUser() {
        int id = Utils.intInput("Ingrese el id del usuario a editar: ", MenuName.USER_ADMIN);
        User user = getUserById(id);

        Menus.customHeaderMenu("Editar el usuario " + user.getName() + " " + user.getLastName());
        String name = Utils.stringInput("Ingrese su nombre (ingrese 'NO' si no desea editar): ", MenuName.USER_ADMIN);
        if (!name.equalsIgnoreCase("no")) {
            user.setName(name);
        }
        String lastName = Utils.stringInput("Ingrese su apellido (ingrese 'NO' si no desea editar): ", MenuName.USER_ADMIN);
        if (!lastName.equalsIgnoreCase("no")) {
            user.setLastName(lastName);
        }
        String age = Utils.stringInput("Ingrese su edad (ingrese 'NO' si no desea editar): ", MenuName.USER_ADMIN);
        if (!age.equalsIgnoreCase("no")) {
            user.setAge(Integer.parseInt(age));
        }
        String email = Utils.stringInput("Ingrese su email (ingrese 'NO' si no desea editar): ", MenuName.USER_ADMIN);
        if (!email.equalsIgnoreCase("no")) {
            user.setEmai(email);
        }
        String password = Utils.stringInput("Ingrese su password (ingrese 'NO' si no desea editar): ", MenuName.USER_ADMIN);
        if (!password.equalsIgnoreCase("no")) {
            user.setPassword(password);
        }
        System.out.println("");
        System.out.println("Usuario modificado con éxito");
        AdminUserMenu.getMenu();

    }


    public static User getUserByEmail(String email) {
        for (User user : users) {
            if (Objects.equals(user.getEmail(), email)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserById(int id) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        System.out.println("");
        System.out.println("No se encontro el usuario");
        AdminUserMenu.getMenu();
        return null;
    }

    public static void deleteUser() {
        int id = Utils.intInput("Ingrese el ID del Usuario que quiere eleminar: ", MenuName.USER_ADMIN);
        User user = getUserById(id);
        if (user == null) {
            System.out.println("");
            System.out.println("No se encontró ningún usuario con ese ID");
            AdminUserMenu.getMenu();

        }
        user.setActive(false);
        System.out.println("");
        System.out.println("Usuario eliminado con éxito");
        AdminUserMenu.getMenu();
    }

    public static void showUsers() {
        UserGrid.generateHeaders();
        for (User user : users) {
            if (user.isActive()) {
                UserGrid.showLineUser(user);
            }
        }
        AdminUserMenu.getMenu();
    }

    public static void setUsers(ArrayList<User> users) {
        UserServices.users = users;
    }

    public static void ShowButacas(){
        
    }
}
