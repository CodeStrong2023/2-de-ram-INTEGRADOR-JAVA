package grid;

import users.User;

import java.util.ArrayList;

public class UserGrid {
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
    private int fullNameMaxlength;
    private int emailMaxlength;

    public void generateHeaders() {
        // Texto de las cabeceras
        this.clearData();
        this.id.append("| ID");
        this.fullName.append("| Nombre y apllido");
        this.age.append("| Edad");
        this.email.append("| Email");
        this.role.append("| Rol");
        this.setFullNameMaxLength();
        this.setEmailMaxLength();

    }

    // Seteamos la longitud máxima de los datos ingresados para dar flexibilidad a la grilla
    private void setFullNameMaxLength() {
        if(this.fullName.length() > this.fullNameMaxlength) {
            this.fullNameMaxlength = this.fullName.length();
        }
    }
    private void setEmailMaxLength() {
        if(this.email.length() > this.emailMaxlength) {
            this.emailMaxlength = this.email.length();
        }
    }

    public void gridUsers (ArrayList<User> users) {
        for(User user : users) {
            if(user.isActive()) {
                this.setUser(user);
            }
        }
    }

    private void setUser(User user) {
        this.clearData();
        this.id.append("| ");
        this.id.append(user.getId());
        this.id.append(" ".repeat(idLine.length() - this.id.length()));
        this.fullName.append("| ");
        this.fullName.append(user.getName());
        this.fullName.append(" ");
        this.fullName.append(user.getLastName());
        this.fullName.append(" ".repeat(this.fullNameLine.length() - this.fullName.length()));
        this.setFullNameMaxLength();
        this.age.append("| ");
        this.age.append(user.getAge());
        this.age.append(" ".repeat(this.ageLine.length() - this.age.length()));
        this.email.append("| ");
        this.email.append(user.getEmail());
//        this.email.append(" ".repeat(this.emailLine.length() - this.email.length()));
        this.setEmailMaxLength();
        this.role.append("| ");
        this.role.append(user.getRole());
        this.role.append(" ".repeat(this.roleLine.length() - this.role.length()));
        this.role.append(" |");
        StringBuilder userShowLine = new StringBuilder();
        userShowLine.append(this.id);
        userShowLine.append(this.fullName);
        userShowLine.append(this.age);
        userShowLine.append(this.email);
        userShowLine.append(this.role);
        System.out.println(userShowLine);
    }
    private void clearData() {
        this.id.delete(0, this.id.length());
        this.fullName.delete(0, this.fullName.length());
        this.age.delete(0, this.age.length());
        this.email.delete(0, this.email.length());
        this.role.delete(0, this.role.length());
    }

    private void headersLines() {
        // Lineas de la cabecera
        this.idLine.append("+");
        this.idLine.append("-".repeat(6));
        this.id.append(" ".repeat(idLine.length() - this.id.length()));
        this.fullNameLine.append("+");
        this.fullNameLine.append("-".repeat(fullNameMaxlength - 1));
        this.fullName.append(" ".repeat(fullNameLine.length() - this.fullName.length()));
        this.ageLine.append("+");
        this.ageLine.append("-".repeat(6));
        this.age.append(" ".repeat(ageLine.length() - this.age.length()));
        this.emailLine.append("+");
        this.emailLine.append("-".repeat(emailMaxlength - 1));
        this.email.append(" ".repeat(emailLine.length() - this.email.length()));
        this.roleLine.append("+");
        this.roleLine.append("-".repeat(10));
        this.roleLine.append("+");
        this.role.append(" ".repeat(roleLine.length() - this.role.length() -1));
        this.role.append("|");
    }

    public void printTool() {
        StringBuilder line = new StringBuilder();
        line.append(idLine);
        line.append(fullNameLine);
        line.append(ageLine);
        line.append(emailLine);
        line.append(roleLine);

        StringBuilder namesHeader = new StringBuilder();
        namesHeader.append(this.id);
        namesHeader.append(this.fullName);
        namesHeader.append(this.age);
        namesHeader.append(this.email);
        namesHeader.append(this.role);

        System.out.println(line);
        System.out.println(namesHeader);
        System.out.println(line);
    }

}
