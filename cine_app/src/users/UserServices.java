package users;

import auth.SessionUser;
import grid.UserGrid;
import menus.AdminUserMenu;
import menus.Menus;
import utils.Utils;

import java.util.ArrayList;
import java.util.Objects;

import javax.xml.transform.Source;

public class UserServices {
    public static ArrayList<User> users = new ArrayList<>();

    public static void addUser() {
        // Evaluar la posibilidad de hacer unos métodos de verificación de datos como validators en el package utils
        int justInCase = Utils.intInput("Confirme si desea registrarse ingresando '1'(Si) o '2'(Volver al menú principal): ");
        if(justInCase > 0 && justInCase < 3) {
            if(justInCase == 1){
                Menus.customHeaderMenu("Agregar un usuario nuevo");
                String name = Utils.stringInput("Ingrese su nombre: ");
                String lastName = Utils.stringInput("Ingrese su apellido: ");
                int age = Utils.intInput("Ingrese su edad: ");
                String email = Utils.stringInput("Ingrese su email: ");
                String password = Utils.stringInput("Ingrese su password: ");
                users.add(new User(name, lastName, age, email, password));
                System.out.println("Usuario agregado exitosamente");
                Menus.maninMenu();
            } else {
                Menus.maninMenu();
            }
        } else {
            while(justInCase < 0 || justInCase > 2){
                justInCase = Utils.intInput("|X| ERROR |X| \nIngrese '1'(Registrarse) o '2'(Volver al menú principal): ");
            }
            if(justInCase == 1 ){
                addUser();
            } else{
                Menus.maninMenu();
            }
        }
        
    }

    public static void addMockUser() {
        users.add(new User("Luis", "Mera", 37, "admin@admin.com", "admin", "admin"));
        users.add(new User("Juan", "Perez", 22, "jp@gmail.com", "123"));
        users.add(new User("Mariana", "Diaz", 25, "md@gmail.com", "123"));
    }

    public static void editUser() {
        int id = Utils.intInput("Ingrese el id: ");
        User user = getUserById(id);

        if (user == null) {
            System.out.println("");
            System.out.println("No se encontro el usuario");
            AdminUserMenu.getMenu(SessionUser.user.getName());
        }

        Menus.customHeaderMenu("Editar el usuario " + user.getName() + " " + user.getLastName());
        String name = Utils.stringInput("Ingrese su nombre (ingrese 'NO' si no desea editar): ").toLowerCase();
        if (!name.equalsIgnoreCase("no")) {
            user.setName(name);
        }
        String lastName = Utils.stringInput("Ingrese su apellido (ingrese 'NO' si no desea editar): ").toLowerCase();
        if (!lastName.equalsIgnoreCase("no")) {
            user.setLastName(lastName);
        }
        String age = Utils.stringInput("Ingrese su edad (ingrese 'NO' si no desea editar): ").toLowerCase();
        if (!age.equalsIgnoreCase("no")) {
            user.setAge(Integer.parseInt(age));
        }
        String email = Utils.stringInput("Ingrese su email (ingrese 'NO' si no desea editar): ").toLowerCase();
        if (!email.equalsIgnoreCase("no")) {
            user.setEmai(email);
        }
        String password = Utils.stringInput("Ingrese su password (ingrese 'NO' si no desea editar): ").toLowerCase();
        if (!password.equalsIgnoreCase("no")) {
            user.setPassword(password);
        }
        AdminUserMenu.getMenu(SessionUser.user.getName());

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
        return null;
    }
    public static void showUsers() {
        UserGrid.generateHeaders();
        for (User user : users) {
            if(user.isActive()) {
                UserGrid.showLineUser(user);
            }
        }
        AdminUserMenu.getMenu(SessionUser.user.getName());
    }

    public static void setUsers(ArrayList<User> users) {
        UserServices.users = users;
    }


}
