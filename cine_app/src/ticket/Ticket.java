package ticket;

import function.Function;
import users.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private String code;
    private String date;
    private User user;
    private Function function;
    private int QuantityT;
    private int ticketValue;

    public Ticket(User user, Function function, String code, int QuantityT) {
        this.user = user;
        this.function = function;
        this.code = code;
        this.date = this.generateDate();
        this.QuantityT = QuantityT;
        this.ticketValue = 1200;
    }

    private String generateDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(dateNow);
    }
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
