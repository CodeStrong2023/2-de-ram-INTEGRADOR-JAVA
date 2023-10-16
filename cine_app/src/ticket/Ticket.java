package ticket;

import function.Function;
import users.User;

public class Ticket {
    private int code;
    private User user;
    private Function function;

    public Ticket(User user, Function function) {
        this.user = user;
        this.function = function;
        this.code = TicketServices.generateCode();
    }
}
