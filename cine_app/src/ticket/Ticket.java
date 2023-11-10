package ticket;

import function.Function;
import users.User;

import java.text.SimpleDateFormat;
import java.util.Date;
// Clase que representa una entrada asociada a una función y usuario en el sistema
public class Ticket {
    //Atributos
    private String code;
    private String date;
    private User user;
    private Function function;

    //Constructor
    public Ticket(User user, Function function, String code) {
        this.user = user;
        this.function = function;
        this.code = code;
        this.date = this.generateDate();
    }
    // Método privado para generar la fecha actual en el formato "dd/MM/yyyy"

    private String generateDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(dateNow);
    }
    //Getters
    public String getCode() {
        return code;
    }

    public User getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public Function getFunction() {
        return function;
    }
}
