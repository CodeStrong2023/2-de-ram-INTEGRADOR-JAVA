package grid;

import users.User;

import java.util.ArrayList;

public class UserGrid {
    private static StringBuilder idLine = new StringBuilder();
    private static StringBuilder fullNameLine = new StringBuilder();
    private static StringBuilder ageLine = new StringBuilder();
    private static StringBuilder emailLine = new StringBuilder();
    private static StringBuilder roleLine = new StringBuilder();
    private static StringBuilder id = new StringBuilder();
    private static StringBuilder fullName = new StringBuilder();
    private static StringBuilder age = new StringBuilder();
    private static StringBuilder email = new StringBuilder();
    private static StringBuilder role = new StringBuilder();

    public static void generateHeaders() {
        clearData();
        // Texto de las cabeceras
        idLine.append("-".repeat(4));
        fullNameLine.append("-".repeat(50));
        ageLine.append("-".repeat(6));
        emailLine.append("-".repeat(40));
        roleLine.append("-".repeat(10));
        id.append("ID");
        fullName.append("NOMBRE Y APELLIDO");
        age.append("EDAD");
        email.append("EMAIL");
        role.append("ROL");
        String line = "+" + idLine + "+" + fullNameLine + "+" + ageLine + "+" + emailLine + "+" + roleLine + "+";
        String titles = "| " + id + " | " + fullName + "                                | " + age + " | " + email + "                                  | " + role + "      |";
        System.out.println(line);
        System.out.println(titles);
        System.out.println(line);
    }

    public static void showLineUser(User user) {
        UserGrid.clearData();
        id.append("| ");
        id.append(user.getId());
        id.append(" ".repeat(5 - id.length()));
        fullName.append("| ");
        fullName.append(user.getName());
        fullName.append(" ");
        fullName.append(user.getLastName());
        fullName.append(" ".repeat(51 - fullName.length()));
        age.append("| ");
        age.append(user.getAge());
        age.append(" ".repeat(7 - age.length()));
        email.append("| ");
        email.append(user.getEmail());
        email.append(" ".repeat(41 - email.length()));
        role.append("| ");
        role.append(user.getRole());
        role.append(" ".repeat(10 - role.length()));
        role.append(" |");
        String userLine = id.toString() + fullName + age + email + role;
        System.out.println(userLine);
    }

    private static void clearData() {
        id.delete(0, id.length());
        fullName.delete(0, fullName.length());
        age.delete(0, age.length());
        email.delete(0, email.length());
        role.delete(0, role.length());
        idLine.delete(0, idLine.length());
        fullNameLine.delete(0, fullNameLine.length());
        ageLine.delete(0, ageLine.length());
        emailLine.delete(0, emailLine.length());
        roleLine.delete(0, roleLine.length());
    }

}
