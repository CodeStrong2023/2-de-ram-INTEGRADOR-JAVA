package users;

import auth.SessionUser;
import grid.UserGrid;
import menus.AdminUserMenu;
import menus.Menus;
import utils.Utils;

import java.util.ArrayList;
import java.util.Objects;

public class UserServices {
    // Lista que almacena todos los usuarios del sistema
    public static ArrayList<User> users = new ArrayList<>();

    public static void addUser() {
        // Evaluar la posibilidad de hacer unos métodos de verificación de datos como validators en el package utils
        Menus.customHeaderMenu("Agregar un usuario nuevo");
        String name = Utils.stringInput("Ingrese su nombre: ");
        String lastName = Utils.stringInput("Ingresee su apellido: ");
        int age = Utils.intInput("Ingrese su edad: ");
        String email = Utils.stringInput("Ingrese su email: ");
        String password = Utils.stringInput("Ingrese su password: ");
        users.add(new User(name, lastName, age, email, password));
        System.out.println("Usuario agregado exitosamente");
        Menus.maninMenu();
    }
    // Método para agregar usuarios de prueba al sistema
  public static void addMockUser() {
        users.add(new User("Luis", "Mera", 37, "admin@admin.com", "admin", "admin"));
        users.add(new User("Juan", "Perez", 22, "jp@gmail.com", "123"));
        users.add(new User("Mariana", "Diaz", 25, "md@gmail.com", "123"));
    }
    // Método para editar la información de un usuario existente en el sistema
    public static void editUser() {
        int id = Utils.intInput("Ingrese el id: ");
        User user = getUserById(id);

        if (user == null) {
            System.out.println("");
            System.out.println("No se encontro el usuario");
            AdminUserMenu.getMenu(SessionUser.user.getName());
        }

        Menus.customHeaderMenu("Ediatar el usuario " + user.getName() + " " + user.getLastName());
        String name = Utils.stringInput("Ingrese su nombre (ingrese NO si no desea editar): ").toLowerCase();
        if (!name.equalsIgnoreCase("no")) {
            user.setName(name);
        }
        String lastName = Utils.stringInput("Ingresee su apellido (ingrese NO si no desea editar): ").toLowerCase();
        if (!lastName.equalsIgnoreCase("no")) {
            user.setLastName(lastName);
        }
        String age = Utils.stringInput("Ingrese su edad (ingrese NO si no desea editar): ").toLowerCase();
        if (!age.equalsIgnoreCase("no")) {
            user.setAge(Integer.parseInt(age));
        }
        String email = Utils.stringInput("Ingrese su email (ingrese NO si no desea editar): ").toLowerCase();
        if (!email.equalsIgnoreCase("no")) {
            user.setEmai(email);
        }
        String password = Utils.stringInput("Ingrese su password (ingrese NO si no desea editar): ").toLowerCase();
        if (!password.equalsIgnoreCase("no")) {
            user.setPassword(password);
        }
        AdminUserMenu.getMenu(SessionUser.user.getName());

    }
    //Metodo para obtener el usuario por su email
    public static User getUserByEmail(String email) {
        for (User user : users) {
            if (Objects.equals(user.getEmail(), email)) {
                return user;
            }
        }
        return null;
    }
    // Método para obtener un usuario por su identificador único
    public static User getUserById(int id) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }
    //Metodo que muestra todos los usuarios
    public static void showUsers() {
        UserGrid.generateHeaders();
        for (User user : users) {
            if(user.isActive()) {
                UserGrid.showLineUser(user);
            }
        }
        AdminUserMenu.getMenu(SessionUser.user.getName());
    }
    // Método para establecer la lista de usuarios del sistema
    public static void setUsers(ArrayList<User> users) {
        UserServices.users = users;
    }


}
