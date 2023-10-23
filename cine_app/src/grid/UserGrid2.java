package grid;

import users.User;

import java.util.ArrayList;

public class UserGrid2 {
    private StringBuilder idLine = new StringBuilder();
    private StringBuilder fullNameLine = new StringBuilder();
    private StringBuilder ageLine = new StringBuilder();
    private StringBuilder emailLine = new StringBuilder();
    private StringBuilder roleLine = new StringBuilder();
    private StringBuilder id = new StringBuilder();
    private StringBuilder fullName = new StringBuilder();
    private StringBuilder age = new StringBuilder();
    private StringBuilder email = new StringBuilder();
    private StringBuilder role = new StringBuilder();

    public void generateHeaders() {
        // Texto de las cabeceras
        this.idLine.append("-".repeat(4));
        this.fullNameLine.append("-".repeat(50));
        this.ageLine.append("-".repeat(6));
        this.emailLine.append("-".repeat(40));
        this.roleLine.append("-".repeat(10));
        this.id.append("ID");
        this.fullName.append("NOMBRE Y APLELIDO");
        this.age.append("EDAD");
        this.email.append("EMAIL");
        this.role.append("ROL");
        String line = "+" + idLine + "+" + fullNameLine + "+" + ageLine + "+" + emailLine + "+" + roleLine + "+";
        String titles = "| " + id + " | " + fullName + "                                | " + age + " | " + email + "                                  | " + role + "      |";
        System.out.println(line);
        System.out.println(titles);
        System.out.println(line);
    }

    public void showLineUser(User user) {
        this.clearData();
        this.id.append("| ");
        this.id.append(user.getId());
        this.id.append(" ".repeat(5 - this.id.length()));
        this.fullName.append("| ");
        this.fullName.append(user.getName());
        this.fullName.append(" ");
        this.fullName.append(user.getLastName());
        this.fullName.append(" ".repeat(51 - this.fullName.length()));
        this.age.append("| ");
        this.age.append(user.getAge());
        this.age.append(" ".repeat(7 - this.age.length()));
        this.email.append("| ");
        this.email.append(user.getEmail());
        this.email.append(" ".repeat(41 - email.length()));
        this.role.append("| ");
        this.role.append(user.getRole());
        this.role.append(" ".repeat(10 - role.length()));
        this.role.append(" |");
        String userLine = id.toString() + fullName + age + email + role;
        System.out.println(userLine);
    }

    public void showUsers(ArrayList<User> users) {
        for(User user : users) {
            this.showLineUser(user);
        }
    }

    private void clearData() {
        this.id.delete(0, this.id.length());
        this.fullName.delete(0, this.fullName.length());
        this.age.delete(0, this.age.length());
        this.email.delete(0, this.email.length());
        this.role.delete(0, this.role.length());
    }

}
