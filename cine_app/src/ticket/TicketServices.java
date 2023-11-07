package ticket;

import auth.SessionUser;
import function.Function;
import function.FunctionServices;
import menus.Menus;
import menus.UserMenu;
import users.User;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class TicketServices {
    public static ArrayList<Ticket> tickets = new ArrayList<>();
    public static void addTicket(User user, Function function){
        tickets.add(new Ticket(user, function, generateCode()));
    }
    private static String generateCode() {
        // Generamos un código alfanumérico random con UUID
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }
    public static Ticket getTicketByCode(String code){
        for (Ticket ticket : tickets) {
            if(ticket.getCode().equals(code)){
                return ticket;
            }
        }
        return null;
    }
    public static void purchaseTicket() {
        Menus.customHeaderMenu("Compra de entrada");
        int functionId = Utils.intInput("Ingrese el número de la función: ");
        Function function = FunctionServices.getFunctionById(functionId);
        while (function == null) {
            System.out.println("Número de función no válido");
            functionId = Utils.intInput("Ingrese el número de la función: ");
            function = FunctionServices.getFunctionById(functionId);
        }
       Ticket ticket = new Ticket(SessionUser.user, function, generateCode());
        tickets.add(ticket);
        showTicket(ticket.getCode());

    }
    public static void showTicket(String code){
        Ticket ticket = getTicketByCode(code);
        if(ticket == null) {
            System.out.println("");
            System.out.println("Código incorrecto");
            return;
        }

        // Datos
        String fullName = ticket.getUser().getName() + " " + ticket.getUser().getLastName();
        String title = ticket.getFunction().getMovie().getTitle();
        String schedule = ticket.getFunction().getSchedule().toString();
        String room = String.valueOf(ticket.getFunction().getRoom());
        String date = ticket.getDate();

        Menus.customHeaderMenu("TICKET DE COMPRA");
        System.out.println("Nombre y Aplellido: " + fullName );
        System.out.println("Película: " + title);
        System.out.println("Horario: " + schedule);
        System.out.println("N° de Sala: " + room);
        System.out.println("Fecha de compra: " + date);
        System.out.println("Código de compra: " + code);
        UserMenu.getMenu(SessionUser.user.getName());
        Menus.customHeaderMenu("CINE APP");
    }
}
