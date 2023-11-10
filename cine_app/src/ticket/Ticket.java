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
    private int QuantityT;
    private int ticketValue;


    //Constructor
    public Ticket(User user, Function function, String code) {

    public Ticket(User user, Function function, String code, int QuantityT) {

        this.user = user;
        this.function = function;
        this.code = code;
        this.date = this.generateDate();
        this.QuantityT = QuantityT;
        this.ticketValue = 1200;
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

   public int getQuantityT(){
        return QuantityT;
   }

   public void setQuantityT(int QuantityT){
        this.QuantityT = QuantityT;
   }
   public int getTicketValue(){
        return this.ticketValue;
   }

}
