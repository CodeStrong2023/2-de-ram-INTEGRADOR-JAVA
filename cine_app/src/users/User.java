package users;

import jdk.jshell.execution.Util;
import utils.Utils;

public class User {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String emai;
    private String password;
    private String role;
    private boolean isActive;

    public User(String name, String lastName, int age, String emai, String password) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.emai = emai;
        this.password = password;
        this.role = "user";
        this.isActive = true; // Por defecto todos los usuarios que se crean van a estar activos
        this.id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }
}
