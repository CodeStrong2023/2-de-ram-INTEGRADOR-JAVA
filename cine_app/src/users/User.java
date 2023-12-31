package users;

public class User {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private String role;
    private boolean isActive;
    private static int countId;

    public User(String name, String lastName, int age, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.role = "user";
        this.isActive = true; // Por defecto todos los usuarios que se crean van a estar activos
        this.id = ++countId;
    }

    public User(String name, String lastName, int age, String email, String password, String role) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = true; // Por defecto todos los usuarios que se crean van a estar activos
        this.id = ++countId;
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


    public String getEmail() {
        return email;
    }

    public void setEmai(String email) {
        this.email = email;
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
